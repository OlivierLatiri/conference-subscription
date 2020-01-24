package conferences.init;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import conferences.component.Conference;
import conferences.component.Periode;
import conferences.repository.ConferenceRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataBase {


	//	Resource resource = new ClassPathResource("config.xml");
	//	File xmlFile = resource.getFile();
	//	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	//	DocumentBuilder builder = factory.newDocumentBuilder();
	//	Document doc = (Document) builder.parse(xmlFile);
	@Bean
	CommandLineRunner initConferenceDatabase(ConferenceRepository repository) {
		try {
			Resource resource = new ClassPathResource("config.xml");
			File xmlFile;
			xmlFile = resource.getFile();
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
					Float earlyPrice = Float.valueOf(conferenceElement.getElementsByTagName("early").item(0).getAttributes().getNamedItem("price").getNodeValue());
					String beginEarlyDate = conferenceElement.getElementsByTagName("early").item(0).getAttributes().getNamedItem("begin").getNodeValue();
					String endEarlyDate = conferenceElement.getElementsByTagName("early").item(0).getAttributes().getNamedItem("end").getNodeValue();
					Float latePrice = Float.valueOf(conferenceElement.getElementsByTagName("late").item(0).getAttributes().getNamedItem("price").getNodeValue());
					String beginLateDate = conferenceElement.getElementsByTagName("late").item(0).getAttributes().getNamedItem("begin").getNodeValue();
					String endLateDate = conferenceElement.getElementsByTagName("late").item(0).getAttributes().getNamedItem("end").getNodeValue();


					Periode earlyPeriod;
					Periode latePeriod;
					earlyPeriod = new Periode(new SimpleDateFormat("dd-MM-yyyy").parse(beginEarlyDate),new SimpleDateFormat("dd-MM-yyyy").parse(endEarlyDate));

					latePeriod = new Periode(new SimpleDateFormat("dd-MM-yyyy").parse(beginLateDate),new SimpleDateFormat("dd-MM-yyyy").parse(endLateDate));

					log.info("Preloading " + repository.save(new Conference(name,category,earlyPrice,latePrice,earlyPeriod,latePeriod)));
				}

			}
		} catch (ParseException | IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return args -> {

		};
	}

	//	@Bean
	//	CommandLineRunner initVIPDatabase(VIPRepository repository) {
	//		File xmlFile = new File("config.xml");
	//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	//		DocumentBuilder builder = factory.newDocumentBuilder();
	//		Document doc = (Document) builder.parse(xmlFile);
	//		NodeList studentNodes = doc.getElementsByTagName("student");
	//
	//		return args -> {
	//			log.info("Preloading " + repository.save(new VIP));
	//		};
	//	}
	//
	//	@Bean
	//	CommandLineRunner initAdminDatabase(AdminRepository repository) {
	//		File xmlFile = new File("config.xml");
	//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	//		DocumentBuilder builder = factory.newDocumentBuilder();
	//		Document doc = (Document) builder.parse(xmlFile);
	//		NodeList studentNodes = doc.getElementsByTagName("student");
	//
	//		return args -> {
	//			log.info("Preloading " + repository.save(new Admin()));
	//		};
	//	}
}
