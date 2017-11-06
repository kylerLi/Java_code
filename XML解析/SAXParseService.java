package XML解析;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * SAX解析XML文件
 * Simple API for XML
 * SAX 是一种 推模式 XML
 * 一边解析 ，一边处理，一边释放内存资源,不允许在内存中保留大规模xml 数据
 * @author leo
 *
 */
public class SAXParseService {
	// 创建SAX解析器，并利用PersonHandler对象进行解析，并将结果返回
	public List<Person> getPersonList(InputStream inStream) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		PersonHandler handler = new PersonHandler();
		parser.parse(inStream, handler);
		List<Person> personList = handler.getPersons();
		return personList;
	}

	@Test
	public void testSAX() throws Throwable {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("sax.xml");
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		System.out.println(br.readLine());
		SAXParseService service = new SAXParseService();
		List<Person> personList = service.getPersonList(is);
		for (Person person : personList) {
			System.out.println(person.getName());
			System.out.println(person.getId());
		}
		
		is.close();
	}

}

/**
 * 基于事件的推模式读取XML
 * startDocument
 * startElement
 * characters
 * endElement
 * endDocument
 * |--使用SAXParserFactory创建SAX解析工厂
      	|--SAXParserFactory spf = SAXParserFactory.newInstance();
	  |--通过SAX解析工厂得到解析器对象
      	|--SAXParser sp = spf.newSAXParser();
      |--通过解析器对象解析xml文件
      	|--sp.parse("sax.xml“,new XMLContentHandler());
      	|--这里的XMLContentHandler 继承 DefaultHandler
      		|--在startElement() endElement() 获得 开始和结束元素名称
      		|--在characters() 获得读取到文本内容
      		|--在startElement() 读取属性值 
 * 
 * @author leo
 *
 */
class PersonHandler extends DefaultHandler {

	List<Person> persons;
	Person person;
	String elementTag = null;

	public List<Person> getPersons() {
		return persons;
	}

	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("person".equals(qName)) {
			person = new Person();
			person.setId(new Integer(attributes.getValue(0)));
		}
		elementTag = qName;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (elementTag != null) {
			String data = new String(ch, start, length).trim();
			// 为避免出现空指针异常，不要使用elementTag.equals("name")
			if ("name".equals(elementTag)) {
				person.setName(data);
			} else if ("age".equals(elementTag)) {
				person.setAge(Integer.valueOf(data));
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		/*
		 * 注意此时不能用elementTag，因为有可能遇到两个连续的结束标签，连续调用
		 * endElement，第一个结束标记调用时已经讲elementTag赋值为null，第二次调用会出现 空指针异常
		 */
		if ("person".equals(qName) && person != null) {
			persons.add(person);
			person = null;
		}
		elementTag = null;
	}

	public void endDocument() throws SAXException {
	}

}
