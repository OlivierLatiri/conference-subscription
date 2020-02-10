package conferences.init;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class test {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub


		Resource resource = new ClassPathResource("config.xml");
		File xmlFile = resource.getFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = (Document) builder.parse(xmlFile);


			NodeList conferencesNodes = doc.getElementsByTagName("conference");

			for(int i=0; i<conferencesNodes.getLength(); i++) {
				Node conferenceNode = conferencesNodes.item(i);
				if(conferenceNode.getNodeType() == Node.ELEMENT_NODE) {
					Element conferenceElement = (Element) conferenceNode;
					String name = conferenceElement.getElementsByTagName("name").item(0).getTextContent();
					String category = conferenceElement.getElementsByTagName("category").item(0).getTextContent();
					String earlyPrice = conferenceElement.getElementsByTagName("early").item(0).getAttributes().getNamedItem("price").getNodeValue();
					System.out.println(earlyPrice);
				}
			}
			return ;
	}

}
