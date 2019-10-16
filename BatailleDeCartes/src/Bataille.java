import java.util.ArrayList;
import java.util.Random;

public class Bataille {

	public static void main(String[] args) {
		ArrayList<Carte> paquetCartes = new ArrayList<Carte>();
		Joueur j1 = new Joueur(0);
		Joueur j2 = new Joueur(0);
		Random r = new Random();
		System.out.println("Distribution des cartes...");
		for(int i = 0; i <= 3; i++) {
			for(int j = 2; j <= 14; j++) {
				Carte carteToAdd = new Carte(i, j);
				paquetCartes.add(carteToAdd);
			}			  
		}
		while (paquetCartes.size() > 0) {
			int posCarte1 = 0 + r.nextInt(paquetCartes.size() - 0);
			Carte carte1 = paquetCartes.get(posCarte1);
			j1.ajouterCarte(carte1);
			paquetCartes.remove(carte1);
			int posCarte2 = 0 + r.nextInt(paquetCartes.size() - 0);
			Carte carte2 = paquetCartes.get(posCarte2);
			j2.ajouterCarte(carte2);
			paquetCartes.remove(carte2);
		}
		System.out.println("Carte distribuées ! Début de la partie !");
		while (j1.getCartes().size() != 0 || j2.getCartes().size() != 0) {
			if (j1.getCartes().size() == 0 || j2.getCartes().size() == 0) { //Ceci est annormalement utile.
				break;
			}
			ArrayList<Carte> cartesDuTour = new ArrayList<Carte>();
			int posCarteJ1;
			int posCarteJ2;
			if (j1.getCartes().size() == 1 || j2.getCartes().size() == 1) {
				if (j1.cartes.get(0).getValeur() == j2.cartes.get(0).getValeur()) {
					break;
				}
				posCarteJ1 = 0;
				posCarteJ2 = 0;
			} else {
				posCarteJ1 = r.nextInt(j1.getCartes().size());
				posCarteJ2 = r.nextInt(j2.getCartes().size());	
			}
			Carte carteJ1 = j1.tireUneCarte(posCarteJ1);
			Carte carteJ2 = j2.tireUneCarte(posCarteJ2);
			cartesDuTour.add(carteJ1);
			cartesDuTour.add(carteJ2);
			while (carteJ1.getValeur() == carteJ2.getValeur()) {
				if (j1.getCartes().size() == 1 || j2.getCartes().size() == 1) {
					break;
				}
				System.out.println("Bataille ! joueur 1: "+carteJ1.getValeur()+" Joueur 2: "+carteJ2.getValeur());
				posCarteJ1 = r.nextInt(j1.getCartes().size()-1);
				posCarteJ2 = r.nextInt(j2.getCartes().size()-1);
				int posCarteJ1Retourner = r.nextInt(j1.getCartes().size()-1);
				int posCarteJ2Retourner = r.nextInt(j2.getCartes().size()-1);
				carteJ1 = j1.tireUneCarte(posCarteJ1);
				carteJ2 = j2.tireUneCarte(posCarteJ2);
				Carte carteJ1R = j1.tireUneCarte(posCarteJ1Retourner);
				Carte carteJ2R = j2.tireUneCarte(posCarteJ2Retourner);
				cartesDuTour.add(carteJ1);
				cartesDuTour.add(carteJ2);
				cartesDuTour.add(carteJ1R);
				cartesDuTour.add(carteJ2R);
			}
			System.out.println("joueur 1: "+carteJ1.getValeur()+" de "+carteJ2.getCouleur()+". Joueur 2: "+carteJ2.getValeur()+" de "+carteJ2.getCouleur()+".");
			if (carteJ1.getValeur() > carteJ2.getValeur()) {
				while (cartesDuTour.size() != 0) {
					Carte carteX = cartesDuTour.get(0);
					j1.ajouterCarte(carteX);
					cartesDuTour.remove(0);
				}
				j1.setScore(j1.getScore()+1);
				System.out.println("joueur 1 remporte la manche");
			} else if (carteJ1.getValeur() < carteJ2.getValeur()) {
				while (cartesDuTour.size() != 0) {
					Carte carteX = cartesDuTour.get(0);
					j2.ajouterCarte(carteX);
					cartesDuTour.remove(0);
				}
				j2.setScore(j2.getScore()+1);
				System.out.println("joueur 2 remporte la manche");
			}
		}
		if (j1.getScore() > j2.getScore()) {
			System.out.println("Le joueur 1 gagne ! ("+j1.getScore()+" / "+j2.getScore()+")");
		} else if (j1.getScore() < j2.getScore()) {
			System.out.println("Le joueur 2 gagne ! ("+j2.getScore()+" / "+j1.getScore()+")");
		} else {
			System.out.println("Egalité ! ("+j1.getScore()+" / "+j2.getScore()+")");
		}
	}
}
