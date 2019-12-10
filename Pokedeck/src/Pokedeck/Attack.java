package Pokedeck;


public class Attack {
	private String name;
	private String desc;
	private int power;
	public Attack(String name, String desc, int power) {
		super();
		this.name = name;
		this.desc = desc;
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
