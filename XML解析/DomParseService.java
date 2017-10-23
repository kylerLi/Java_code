package XML解析;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Dom 文档解析
 * Document Object Model 文档对象模型 
 * 将整个xml 加载内存中，形成文档对象，所有对xml操作都对内存中文档对象进行
 * @author leo
 *
 */
public class DomParseService{
	
	public List<Person> getPersonList(InputStream ins){
		DomParseHandler dh = new DomParseHandler();
		return dh.parse("dom.xml");
	}
	
	public int insertPerson(Person person){
		DomParseHandler dh = new DomParseHandler();
		
		return dh.addElement("dom.xml",person);
	}
	
//	@Test
	public void test1(){
		//字节输入流读取XML文档
		InputStream ins = this.getClass().getClassLoader().getResourceAsStream("dom.xml");
		DomParseService ds = new DomParseService();
		List<Person> persons = ds.getPersonList(ins);
		for (Person person : persons) {
			System.out.println(person.getName());
		}
	}
	
	@Test
	public void test2(){
		Person p = new Person("smail", 18, 102);
		insertPerson(p);
	}
}

class DomParseHandler{
	
	private List<Person> persons;
	Person person;
	/*
	 * 添加节点
	 */
	int addElement(String fileName,Person p){
		Document doc = parseDocment(fileName);
		
		Element ele = doc.createElement("person");//添加节点
		ele.setAttribute("id", p.getId()+"");
		Element nameEle = doc.createElement("name");
		nameEle.setTextContent(p.getName());
		ele.appendChild(nameEle);
		
		Element ageEle = doc.createElement("age");
		ageEle.setTextContent(p.getAge()+"");
		ele.appendChild(ageEle);
		
		Element root = doc.getDocumentElement();//根节点
		root.appendChild(ele);
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			DOMSource domsource = new DOMSource(doc);
			StreamResult sr = new StreamResult(new File("dom_bak.xml"));
			transformer.transform(domsource, sr);
			System.out.println("success");
			return 1;
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 * 查询
	 */
	List<Person> parse(String fileName){
		Document doc = parseDocment(fileName);
		Element ele = doc.getDocumentElement();
		NodeList nodes = ele.getChildNodes();
		persons = new ArrayList<Person>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element){
				persons.add(processBean2((Element)node));
			}
			
		}
	
		return persons;
	
	}
	
	/*
	 * 读取xml
	 */
	Document parseDocment(String fileName){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		//构造工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			//解析器
			docBuilder = dbf.newDocumentBuilder();
			//加载XML文档
			Document doc = docBuilder.parse(inputStream);
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/*
	 * property 格式
	 */
	public Person processBean(Element element){
		person = new Person();
		person.setId(Integer.parseInt(element.getAttribute("id")));
		NodeList nodes  = element.getElementsByTagName("property");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element){
				Element ele = (Element)node;
				if(ele.getAttribute("name")!=null && !ele.getAttribute("name").equals("")){
					person.setName(ele.getAttribute("name"));
				}else if(ele.getAttribute("age")!=null && !ele.getAttribute("age").equals("")){
					person.setAge(Integer.parseInt(ele.getAttribute("age").equals("") ? "0":ele.getAttribute("age")) );

				}
			}
		}
		return person;
	}
	
	public Person processBean2(Element element){
		person = new Person();
		// <person id="100"> 获取属性值用 element.getAttribute("id"))
		person.setId(Integer.parseInt(element.getAttribute("id")));
		NodeList nodes = element.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node instanceof Element && node.getNodeName().equals("name")){
				Element ele = (Element)node;
				// <name>Mary</name> 获取元素内部文本用getTextContent()
				person.setName(ele.getTextContent());
			}else if(node instanceof Element && node.getNodeName().equals("age")){
				Element ele = (Element)node;
				person.setAge(Integer.parseInt(ele.getTextContent()));
			}
		}
		return person;
	}
	
}