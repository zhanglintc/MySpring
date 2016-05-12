package co.zhanglintc.MySpring;

import java.lang.reflect.Method;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ApplicationContext {
	private XMLParser xmlParser;

	public ApplicationContext(String xmlPath) {
		this.xmlParser = new XMLParser("src/" + xmlPath);
	}

	private void loadValues(Class<?> clz, Object obj, String id) {
		Element bean = xmlParser.getBeanByID(id);
		NodeList nList = xmlParser.getProperyList(bean);

		for (int i = 0; i < nList.getLength(); i++) {
			try {
				Element ele = (Element) nList.item(i);

				if (xmlParser.containValue(ele)) {
					String name = xmlParser.getAttr(ele, "name");
					String mtdName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
					Method setMtd = clz.getMethod(mtdName, String.class);
					setMtd.invoke(obj, xmlParser.getAttr(ele, "value"));
				}

				if (xmlParser.containRef(ele)) {
					String ref_ID = xmlParser.getAttr(ele, "ref");
					String className = xmlParser.getClassByID(ref_ID);

					Class<?> ref_clz = Class.forName(className);
					Object ref_obj = ref_clz.newInstance();
					loadValues(ref_clz, ref_obj, ref_ID);

					String name = xmlParser.getAttr(ele, "name");
					String mtdName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
					Method setMtd = clz.getMethod(mtdName, ref_clz);
					setMtd.invoke(obj, ref_obj);
				}
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

	public Object getBean(String beanID) {
		try {
			String className = xmlParser.getClassByID(beanID);

			Class<?> clz = Class.forName(className);
			Object obj = clz.newInstance();
			loadValues(clz, obj, beanID);

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
