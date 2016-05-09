package co.zhanglintc.MySpring;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	private Document doc;

	public XMLParser() {
		try {
			File inputFile = new File("src/Beans.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			this.setDoc(dBuilder.parse(inputFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getClassByID(String id) {
		NodeList nList = getBeanList();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(id.equals(eElement.getAttribute("id"))) {
				return eElement.getAttribute("class");
			}
		}
		return null;
	}
	
	public String getValueByName(Element eElement, String name) {
		NodeList nList = getProperyList(eElement);
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element ele = (Element) nNode;
			if(name.equals(ele.getAttribute("name"))) {
				return ele.getAttribute("value");
			}
		}
		return null;
	}
	
	public Element getElementByID(String id) {
		NodeList nList = getBeanList();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(id.equals(eElement.getAttribute("id"))) {
				return eElement;
			}
		}
		return null;
	}
	
	private String getName(Element ele) {
		return ele.getAttribute("name");
	}
	
	private ArrayList<String> getNamesByID(String id) {
		ArrayList<String> names = null;
		NodeList nList = getBeanList();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(id.equals(eElement.getAttribute("id"))) {
				NodeList properties = getProperyList(eElement);
				for (int j = 0; j < properties.getLength(); j++)  {
					Node node = properties.item(j);
					Element property = (Element)node;
					names.add(property.getAttribute("name"));
				}
			}
		}
		
		return names;
	}
	
	private NodeList getProperyList(Element eElement) {
		return eElement.getElementsByTagName("property");
	}
	
	private NodeList getBeanList() {
		return doc.getElementsByTagName("bean");
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
}
