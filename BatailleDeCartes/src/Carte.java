public class Carte {
	private String famille[] = {"Coeur", "Trèfle", "Carreau", "Pique"};
	private String couleur;
	private int valeur;
	
	public Carte(int i, int j) {
		super();
		this.couleur = famille[i];
		this.valeur = j;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
