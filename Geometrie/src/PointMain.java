public class PointMain {
	public static void main(String[] args) {
		Point point1 = new Point(1);
		Point point2 = new Point(2);
		Point point3 = new Point(3);
		Point point4 = new Point(4);
		//System.out.println("retour:"+point3.distance(point4.position));
		//System.out.println("retour:"+point2.distance(point1.position));
		PointColore pointColore1 = new PointColore(4, "rouge");
		//System.out.println("retour:"+pointColore1.distance(point4.position)+". Couleur ="+pointColore1.getColor());
		Carre carre1 = new Carre("0.0","bleu",5);
		System.out.println(carre1);
	}
}
