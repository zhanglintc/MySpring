package co.zhanglintc.UTest;

public class Tool {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void toolEffect() {
		System.out.println("I'm '" + name + "', I can let you fly!");
	}
}
