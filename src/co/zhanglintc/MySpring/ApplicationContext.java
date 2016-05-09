package co.zhanglintc.MySpring;

public class ApplicationContext {
	private String xmlPath;

	public ApplicationContext() {
	}

	public ApplicationContext(String xmlPath) {
		setxmlPath(xmlPath);
	}

	public void setxmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public String getxmlPath() {
		return this.xmlPath;
	}

	public Class<?> getBean(String beanID) throws ClassNotFoundException {
		return Class.forName(beanID);
	}
}
