package Main;

import java.io.IOException;
import com.google.gson.*;

import GUI.Window;
import Pokedeck.*;

public class Main {
	
	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, IOException {		
		//Injection des pokemon present dans le json dans le pokedeck.
        Pokedeck.loadPokedeck();
		//Ouverture de la fenêtre Swing:
		@SuppressWarnings("unused")
		Window win = new Window();
	}
}
