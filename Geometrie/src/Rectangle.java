
public class Rectangle extends FormeGeometrique{
	private int longX;
	private int longY;
	
	public Rectangle(String centre, String couleur, int longX, int longY) {
		super(centre, couleur);
		this.longX = longX;
		this.longY = longY;
	}

	public int getLongX() {
		return longX;
	}

	public void setLongX(int longX) {
		this.longX = longX;
	}

	public int getLongY() {
		return longY;
	}

	public void setLongY(int longY) {
		this.longY = longY;
	}
}
