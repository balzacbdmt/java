public class Point {
	public int position;

	public Point(int position) {
		super();
		this.position = position;
	}
	
	private void moveTo() {
		//TODO déplacer le point
	}

	private void rMoveTo() {
		//TODO déplacer le point par addition
	}
	
	public int distance(int pointDistant) {
		int distance = this.position+pointDistant;
		return distance;
	}
}
