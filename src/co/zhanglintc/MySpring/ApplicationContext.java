package co.zhanglintc.MySpring;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.w3c.dom.Element;

public class ApplicationContext {
	private XMLParser xmlParser;

	public ApplicationContext(String xmlPath) {
		this.xmlParser = new XMLParser("src/" + xmlPath);
	}

	private void loadValues(Class<?> clz, Object obj, String id) {
		Element ele = xmlParser.getBeanByID(id);
		ArrayList<String> nameList = xmlParser.getNameList(ele);

		for (String name : nameList) {
			try {
				String mtdName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method mtd = clz.getMethod(mtdName, String.class);
				mtd.invoke(obj, xmlParser.getValueByName(ele, name));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public XMLParser getXmlParser() {
		return xmlParser;
	}

	public void setXmlParser(XMLParser xmlParser) {
		this.xmlParser = xmlParser;
	}

	public Object getBean(String beanID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String className = xmlParser.getClassByID(beanID);

		Class<?> clz = Class.forName(className);
		Object obj = clz.newInstance();
		loadValues(clz, obj, beanID);
		return obj;
	}
}
