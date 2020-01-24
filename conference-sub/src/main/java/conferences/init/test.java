package conferences.init;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class test {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub


//		Resource resource = new ClassPathResource("config.xml");
//		File xmlFile = resource.getFile();
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document doc = (Document) builder.parse(xmlFile);
//
//
//			NodeList conferencesNodes = doc.getElementsByTagName("conference");
//
//			for(int i=0; i<conferencesNodes.getLength(); i++) {
//				Node conferenceNode = conferencesNodes.item(i);
//				if(conferenceNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element conferenceElement = (Element) conferenceNode;
//					String name = conferenceElement.getElementsByTagName("name").item(0).getTextContent();
//					String category = conferenceElement.getElementsByTagName("categorie").item(0).getTextContent();
//					String earlyPrice = conferenceElement.getElementsByTagName("early").item(0).getAttributes().getNamedItem("price").getNodeValue();
//					System.out.println(earlyPrice);
//				}
//			}
//			return ;
	}

}
