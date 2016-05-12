package co.zhanglintc.UTest;

import co.zhanglintc.MySpring.ApplicationContext;

public class UTest {

	public static void main(String[] args) {
		ApplicationContext context = new ApplicationContext("Beans.xml");
		People zhanglin = (People) context.getBean("aPeople");
		zhanglin.intro();
	}

}
