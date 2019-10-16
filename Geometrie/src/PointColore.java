public class PointColore extends Point {
	private String color;

	public PointColore(int position, String color) {
		super(position);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
