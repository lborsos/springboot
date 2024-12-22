package com.laszlo.borsos.MyApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@SpringBootApplication
public class MyApplication implements CommandLineRunner { // Fontos: Implementálja a CommandLineRunner-t

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File xmlFile = new File("src/main/resources/data.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(xmlFile);

		System.out.println("Root element: " + document.getDocumentElement().getNodeName());

		NodeList personNodes = document.getElementsByTagName("person");
		for (int i = 0; i < personNodes.getLength(); i++) {
			NodeList childNodes = personNodes.item(i).getChildNodes();
			System.out.println("Person " + (i + 1) + ":");
			for (int j = 0; j < childNodes.getLength(); j++) {
				if (childNodes.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					System.out.println("  " + childNodes.item(j).getNodeName() + ": " + childNodes.item(j).getTextContent());
				}
			}
		}
	}
}
