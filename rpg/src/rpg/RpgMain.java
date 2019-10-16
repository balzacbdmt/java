package rpg;
import java.util.Scanner;

public class RpgMain {
	static MagasinArmes ma = new MagasinArmes();
	static Armes armeDuJoueur;
    static Scanner scanner = new Scanner(System.in);
    static Monstres monstreFight;
    
	public static void main(String[] args) {
		echoMenu();
	    
	}
	
    private static void echoMenu() {
        System.out.println("______________________________________");
        System.out.println("|----------------Menu----------------|");
        System.out.println("|------- 1 -> Magasin d'armes -------|");
        if(armeDuJoueur != null) {
            System.out.println("|-  2 -> Combattre un petit monstre -|");
            System.out.println("|-  3 -> Combattre un moyen monstre -|");
            System.out.println("|-  4 -> Combattre un grand monstre -|");
        }
        System.out.println("|----------- 5 -> Quitter -----------|");
        System.out.println("|____________________________________|");
	    int menu = scanner.nextInt();
	    switch (menu) {
	        case 1:
	            echoMagasin();
	            break;
	        case 2:
	        	monstreFight = new PetitMonstre();
	            fightAgainstPmonstre();
	            break;
	        case 3:
	        	monstreFight = new MoyenMonstre();
	            fightAgainstPmonstre();
	            break;
	        case 4:
	        	monstreFight = new GrandMonstre();
	            fightAgainstPmonstre();
	            break;
	        case 5:
	        	System.out.println("Bonne journée !");
	        	break;
	        default:
	            System.out.println("Error");
	            break;
	    }
    }

	private static void fightAgainstPmonstre() {
		int nbCoup = 0;
		while (monstreFight.getPv() > 0) {
			monstreFight.setPv(monstreFight.getPv()-armeDuJoueur.getDamage());
			nbCoup++;
		}
		System.out.println("le "+monstreFight.getName()+" est mort en "+nbCoup+" tirs par votre "+armeDuJoueur.getName());
		echoMenu();
	}

	private static void echoMagasin() {
		ma.printMagasin();
        int armeChoisi = scanner.nextInt();
        if(armeChoisi > ma.getSizeListArmes()) {
        	System.out.println("errrrrreuuuur !");
        	echoMenu();
        	return;
        }
        if(armeDuJoueur != null) {
        	ma.addArmes(armeDuJoueur);
        }
        armeDuJoueur = ma.getArmes(armeChoisi-1);
    	System.out.println("Vous avez choisi l'arme suivante: "+armeDuJoueur.getName());
    	ma.rmArme(armeDuJoueur);
    	echoMenu();		
	}	
}
