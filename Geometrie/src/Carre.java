
public class Carre extends FormeGeometrique{
	private int longX;

	public Carre(String centre, String couleur, int longX) {
		super(centre, couleur);
		this.longX = longX;
	}

	public int getLongX() {
		return longX;
	}

	public void setLongX(int longX) {
		this.longX = longX;
	}
}
