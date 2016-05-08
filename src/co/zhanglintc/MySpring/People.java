package co.zhanglintc.MySpring;

public class People {
	private String name;
	
	public People() {}
	
	People(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void intro() {
		System.out.print("My name is: " + this.name);
	}
}
