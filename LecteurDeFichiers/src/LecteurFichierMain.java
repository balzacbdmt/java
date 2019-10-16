
public class LecteurFichierMain {
	public static void main(String[] args) {
		//Initialisation des 2 fichiers texte.
		FichierTxt fichierTexte = new FichierTxt("/home/balzac/Documents/test.txt","test","txt");
		FichierTxt fichierTexte2 = new FichierTxt("/home/balzac/Documents/test2.txt","test2","txt");
		//Retour de la fonction "getFichierALenvers()".
		System.out.println("**********   getFichierALenvers()    **********");
		System.out.println(fichierTexte.getFichierALenvers());
		//Retour de la fonction "getFichierPalindromique()".
		System.out.println("********** getFichierPalindromique() **********");
		System.out.println(fichierTexte.getFichierPalindromique());
		//Comparaison entre les deux fichiers.
		System.out.println("**********           Diff()          **********");
		//System.out.println(fichierTexte.getContenu());
		//System.out.println(fichierTexte2.getContenu());
		System.out.println(fichierTexte.compareTo(fichierTexte2));
	}
}
