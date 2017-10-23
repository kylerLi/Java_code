package XML解析;

import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.io.input.XmlStreamReader;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.xni.parser.XMLPullParserConfiguration;
import com.sun.xml.internal.fastinfoset.stax.factory.StAXInputFactory;
import com.sun.xml.internal.fastinfoset.stax.util.StAXFilteredParser;

/**
 * Streaming API for XML StAX The Stream API for XML 流 API - JDK6.0新特性 STAX 是一种
 * 拉模式 XML 解析方式,基于指针（Cursor）的 API
 * http://www.cnblogs.com/techlogy/p/5965104.html
 * @author leo
 *
 */
public class StaxParseService {
	List<Person> getPersonList(String fileName) {
		STAXPaseHandler stax = new STAXPaseHandler();
		return stax.parseByCursor(fileName);
	}
	
	@Test
	public void test(){
		StaxParseService staxService = new StaxParseService();
		staxService.getPersonList("stax.xml");
	}
}

class STAXPaseHandler {

	/**
	 * 基于指针
	 * @param fileName
	 * @return
	 */
	List<Person> parseByCursor(String fileName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			// 创建基于指针的读取流对象
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
			while (xmlStreamReader.hasNext()) {
				int id = xmlStreamReader.next();
				switch (id) {
				case XMLStreamConstants.START_DOCUMENT:
					System.out.println("start document");
					break;
				case XMLStreamConstants.START_ELEMENT:
					for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
						System.out.println(
								xmlStreamReader.getAttributeLocalName(i) + "=" + xmlStreamReader.getAttributeValue(i));
					}
					break;
					
				case XMLStreamConstants.CHARACTERS:
					char[] chars = xmlStreamReader.getTextCharacters();
					for (int i = 0; i < chars.length; i++) {
						System.out.println(chars[i]);
					}
					break;

				default:
					break;
				}
			}
			// StAXFilteredParser parser = new
			// StAXFilteredParser(xmlStreamReader,);
			// if(XMLStreamConstants.START_ELEMENT ==
			// xmlStreamReader.getEventType()){
			//
			// }
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 基于迭代器
	 * 待续
	 */

}
