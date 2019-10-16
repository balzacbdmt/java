import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Fichier implements Lecteur{
	private String contenu;
	private String src;
	private String nom;
	private String extension;
	
	public Fichier(String src, String nom, String extension) {
		super();
		this.contenu = "";
		this.src = src;
		this.nom = nom;
		this.extension = extension;
		getFileContent();
	}

	public String getContenu() {
		return contenu;
	}

	public String getSrc() {
		return src;
	}

	public String getNom() {
		return nom;
	}

	public String getExtension() {
		return extension;
	}
	
	public String getFileContent() {
		String contenu = "";
		try {
			InputStream ips = new FileInputStream(this.src);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null) {
				this.contenu += ligne+" ";
			}
			br.close();
		} catch (Exception e){
			  System.out.println(e.toString());
		}
		return contenu;
	}

	public String getFichierALenvers() {
		String ContenuALenvers = "";
		try {
			InputStream ips = new FileInputStream(this.src);
			InputStreamReader ipsr = new InputStreamReader(ips);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null) {
				ContenuALenvers = ligne+" "+ContenuALenvers;
			}
		} catch (Exception e){
			  System.out.println(e.toString());
		}
		return ContenuALenvers;
	}
	
	public String getFichierPalindromique() {
		String contenuPalindromique = "";
		for (int i = this.contenu.length() -1; i>=0; i--) {
			contenuPalindromique = contenuPalindromique+this.contenu.charAt(i);
		}
		return this.getContenu()+contenuPalindromique;
	}
	
	public String compareTo(Fichier file2) {
		String diff = "Les lignes suivantes sont différentes /!\\ :";
		try {
			//this file
			InputStream ips = new FileInputStream(this.src);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne1 = br.readLine();
			//file 2
			InputStream ips2 = new FileInputStream(file2.src);
			InputStreamReader ipsr2 = new InputStreamReader(ips2);
			BufferedReader br2 = new BufferedReader(ipsr2);
			String ligne2 = br2.readLine();
			int nbLigne = 1;
			
			while (ligne1!=null || ligne2!=null) {
				if (ligne1.compareTo(ligne2)!=0) {
					diff += "|"+nbLigne+"| ";
					System.out.println(ligne1);
					System.out.println(ligne2);
				}
				ligne1 = br.readLine();
				ligne2 = br2.readLine();
				nbLigne++;
			}
			br.close();
			br2.close();
		} catch (Exception e){
			  System.out.println(e.toString());
		}
		return diff;
	}
	
}
