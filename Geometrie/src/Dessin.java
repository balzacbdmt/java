import java.util.ArrayList;

//Pattern Composite
public class Dessin extends FormeGeometrique{
	ArrayList<FormeGeometrique> listForme = new ArrayList<FormeGeometrique>();
	
	public Dessin(String centre, String couleur) {
		super(centre, couleur);
		// TODO Auto-generated constructor stub
	}
	
	public void add(FormeGeometrique f) {
		listForme.add(f);
	}
	
	public void translate(int x, int y) {
		/*For each forme in listForme {
			f.translate(forme)
		}*/
	}
}
