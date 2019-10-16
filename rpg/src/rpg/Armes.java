package rpg;

public class Armes {
	protected String name;
	protected int damage;
	protected int price;
	protected int usure;
	public Armes(String name,int d, int p) {
		super();
		this.name = name;
		this.damage = d;
		this.price = p;
		this.usure = 0;
	}
	public int getDamage() {
		return damage;
	}
	public int getPrice() {
		return price;
	}
	public int getUsure() {
		return usure;
	}
	public void setUsure(int usure) {
		this.usure = usure;
	}
	public String getName() {
		return name;
	}
}
