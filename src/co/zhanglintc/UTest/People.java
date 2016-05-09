package co.zhanglintc.UTest;

public class People {
	private String name;
	
	public People() {}
	
	public People(String name) {
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
