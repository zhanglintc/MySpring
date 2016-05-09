package co.zhanglintc.UTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import co.zhanglintc.UTest.People;
import co.zhanglintc.MySpring.XMLParser;

public class UTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		People zhanglin = new People("zhanglin\n");
		zhanglin.intro();
		
		Class<?> clz = Class.forName("co.zhanglintc.UTest.People");
		People yanbin = (People)clz.newInstance();
		Method st = clz.getMethod("setName", String.class);
		st.invoke(yanbin, "shabi\n");
		Method intro = clz.getMethod("intro", (Class[])null);
		intro.invoke(yanbin, (Object[])null);
		
		XMLParser.parseXML();
	}

}