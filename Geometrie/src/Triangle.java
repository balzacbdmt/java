
public class Triangle extends FormeGeometrique{
	private int longX;
	private int longY;
	private int longZ;
	
	public Triangle(String centre, String couleur, int longX, int longY, int longZ) {
		super(centre, couleur);
		this.longX = longX;
		this.longY = longY;
		this.longZ = longZ;
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

	public int getLongZ() {
		return longZ;
	}

	public void setLongZ(int longZ) {
		this.longZ = longZ;
	}
}
