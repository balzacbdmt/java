package GUI;

import java.awt.Color;
import javax.swing.JFrame;

public class WindowAddPokemon extends JFrame{
	public WindowAddPokemon() {
		this.setTitle("Add a new pokemon");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(new BackBoardAddPokemon());
		this.setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
