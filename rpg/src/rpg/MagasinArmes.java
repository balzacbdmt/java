package rpg;

import java.util.ArrayList;

public class MagasinArmes {
	ArrayList<Armes> listArmes = new ArrayList<Armes>();
	Armes famas1 = new Famas();
	Armes carabine1 = new Carabine();
	
	public MagasinArmes() {
		super();
		listArmes.add(famas1);
		listArmes.add(this.carabine1);
	}

	public void printMagasin() {
        System.out.println("");
        System.out.println("__________________________________");
        System.out.println("|---------Magasin d'arme---------|");
		for(int i = 0; i < listArmes.size(); i++) {
	        System.out.println("|----  "+(i+1)+" -> "+listArmes.get(i).getName()+"----|");
		}
        System.out.println("|________________________________|");
	}
	
	public void addArmes(Armes a) {
		listArmes.add(a);
	}
	
	public Armes getArmes(int i) {
		return listArmes.get(i);
	}
	
	public void rmArme(Armes a) {
		listArmes.remove(a);
	}
	
	public int getSizeListArmes() {
		return listArmes.size();
	}
}
