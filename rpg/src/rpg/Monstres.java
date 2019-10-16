package rpg;

public abstract class Monstres {
	protected String name;
	protected int pv;
	public Monstres(String n, int pv) {
		super();
		this.name = n;
		this.pv = pv;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public String getName() {
		return name;
	}
}
