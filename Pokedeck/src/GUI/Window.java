package GUI;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		try { //set icon app
			Image icone = ImageIO.read(new File("/home/balzac/Documents/test.jpg"));
			this.setIconImage(icone);
		} catch(IOException e) {
			e.printStackTrace();
		}
		this.setTitle("Pokedeck"); //to set the title of the window
		this.setSize(800, 600); //to set the size
		this.setResizable(false);
		this.setLocationRelativeTo(null); //To start in the middle of the screen
		this.setContentPane(new BackBoard());
		this.setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
