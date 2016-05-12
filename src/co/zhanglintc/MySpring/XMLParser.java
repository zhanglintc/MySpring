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

	protected XMLParser(String xmlPath) {
		try {
			File inputFile = new File(xmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			this.setDoc(dBuilder.parse(inputFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean containValue(Element ele) {
		if (ele.getAttribute("value").equals("")) {
			return false;
		}

		return true;
	}

	protected boolean containRef(Element ele) {
		if (ele.getAttribute("ref").equals("")) {
			return false;
		}

		return true;
	}

	protected String getClassByID(String id) {
		NodeList nList = getBeanList();
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if (id.equals(eElement.getAttribute("id"))) {
				return eElement.getAttribute("class");
			}
		}
		return null;
	}

	protected String getAttr(Element ele, String attr) {
		return ele.getAttribute(attr);
	}

	protected String getValueByName(Element ele, String name) {
		NodeList nList = getProperyList(ele);
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element e = (Element) nNode;
			if (name.equals(e.getAttribute("name"))) {
				return e.getAttribute("value");
			}
		}

		return null;
	}

	protected String getRefByName(Element ele, String name) {
		NodeList nList = getProperyList(ele);
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element e = (Element) nNode;
			if (name.equals(e.getAttribute("name"))) {
				return e.getAttribute("ref");
			}
		}

		return null;
	}

	protected Element getBeanByID(String id) {
		Element bean = null;
		NodeList nList = getBeanList();
		for (int i = 0; i < nList.getLength(); i++) {
			Element ele = (Element) nList.item(i);
			if (id.equals(ele.getAttribute("id"))) {
				bean = ele;
			}
		}
		return bean;
	}

	protected ArrayList<String> getNameList(Element ele) {
		ArrayList<String> nameList = new ArrayList<String>();
		NodeList properties = getProperyList(ele);
		for (int j = 0; j < properties.getLength(); j++) {
			Element property = (Element) properties.item(j);
			nameList.add(property.getAttribute("name"));
		}

		return nameList;
	}

	protected NodeList getProperyList(Element ele) {
		return ele.getElementsByTagName("property");
	}

	protected NodeList getBeanList() {
		return doc.getElementsByTagName("bean");
	}

	protected Document getDoc() {
		return doc;
	}

	protected void setDoc(Document doc) {
		this.doc = doc;
	}
}
