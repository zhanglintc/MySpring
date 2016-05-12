package co.zhanglintc.UTest;

public class People {
	private String name;
	private String action;
	private Tool tool;

	public People() {
	}

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
		System.out.println("My name is: " + this.name);
		System.out.println("My action is: " + this.action);
		tool.toolEffect();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}
}
