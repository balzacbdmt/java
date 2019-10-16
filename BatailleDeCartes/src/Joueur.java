import java.util.ArrayList;

public class Joueur {
		public ArrayList<Carte> cartes = new ArrayList<Carte>();
		private int score;

		public Joueur(int score) {
			super();
			this.score = score;
		}

		public Carte tireUneCarte(int carte) {
			Carte carteTirer = this.cartes.get(carte);
			this.cartes.remove(carte);
			return carteTirer;
		}
		
		public void ajouterCarte(Carte carteToAdd) {
			this.cartes.add(carteToAdd);
		}

		public ArrayList<Carte> getCartes() {
			return cartes;
		}

		public void setCartes(ArrayList<Carte> cartes) {
			this.cartes = cartes;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
}
