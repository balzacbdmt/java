
public class Cercle extends FormeGeometrique{
	private int rayon;
	
	public Cercle(String centre, String couleur, int rayon) {
		super(centre, couleur);
		this.rayon = rayon;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
}
