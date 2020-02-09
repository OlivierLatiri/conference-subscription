package conferences.init;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import conferences.component.Admin;
import conferences.component.Conference;
import conferences.component.Periode;
import conferences.component.Role;
import conferences.component.VIP;
import conferences.repository.AdminRepository;
import conferences.repository.ConferenceRepository;
import conferences.repository.VIPRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataBase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDataBase.class);
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
			logger.info("------------------------");
	        logger.info("All conferences loading:");
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

		@Bean
		CommandLineRunner initVIPDatabase(VIPRepository repository) {
			try {
				Resource resource = new ClassPathResource("config.xml");
				File xmlFile;
				xmlFile = resource.getFile();
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = (Document) builder.parse(xmlFile);
				NodeList vipNodes = doc.getElementsByTagName("person");
				logger.info("------------------------");
		        logger.info("All VIP loading:");
		        for(int i=0; i<vipNodes.getLength(); i++) {
					Node personNode = vipNodes.item(i);
					if(personNode.getNodeType() == Node.ELEMENT_NODE) {
						Element personElement = (Element) personNode;
						String name = personElement.getElementsByTagName("name").item(0).getTextContent();
						String lastName = personElement.getElementsByTagName("lastname").item(0).getTextContent();
						String email = personElement.getElementsByTagName("email").item(0).getTextContent();
						Role role = Role.valueOf(personElement.getElementsByTagName("role").item(0).getTextContent());

						log.info("Preloading " + repository.save(new VIP(name,lastName, email, role)));
					}

				}
			} catch (IOException | ParserConfigurationException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return args -> {

			};
		}
	
		@Bean
		CommandLineRunner initAdminDatabase(AdminRepository repository) {
			try {
				Resource resource = new ClassPathResource("config.xml");
				File xmlFile;
				xmlFile = resource.getFile();
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = (Document) builder.parse(xmlFile);
				NodeList administrateursNodes = doc.getElementsByTagName("admin");
				logger.info("------------------------");
		        logger.info("All admins loading:");
		        for(int i=0; i<administrateursNodes.getLength(); i++) {
					Node administrateurNode = administrateursNodes.item(i);
					if(administrateurNode.getNodeType() == Node.ELEMENT_NODE) {
						Element adminElement = (Element) administrateurNode;
						String userName = adminElement.getElementsByTagName("username").item(0).getTextContent();
						String password = adminElement.getElementsByTagName("password").item(0).getTextContent();
						String email = adminElement.getElementsByTagName("email").item(0).getTextContent();
						Role role = Role.valueOf(adminElement.getElementsByTagName("role").item(0).getTextContent());

						log.info("Preloading " + repository.save(new Admin(userName,password, email, role)));
					}

				}
			} catch (IOException | ParserConfigurationException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return args -> {

			};
		}
}
