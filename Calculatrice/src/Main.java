import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Main {
	static JTextField textField;
	static JTextField screen;
	static float memoireCalc = 0;
	static String operateur = "";
	static String[] button = {"7", "8", "9", "+","4","5","6","-","1","2","3","/","0","=","res","*"};

	public static void main(String[] args) {
		JPanel panelMain = new JPanel(new GridLayout(2,1));
		JPanel screen_tField = new JPanel(new GridLayout(2,1));
		screen = new JTextField("", 15);
		screen_tField.add(screen);
		textField = new JTextField("", 15);
		screen_tField.add(textField);
		
		JPanel calculatrice = new JPanel(new GridLayout(4,4));
		for (int i=0; i < button.length; i++) {
			JButton buttonB = new JButton(button[i]);
			buttonB.addActionListener(new buttonClick());
			calculatrice.add(buttonB);
		}
		
		JFrame window = new JFrame("Calculatrice");
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new FlowLayout());
		window.add(panelMain);
		panelMain.add(screen_tField);
		panelMain.add(calculatrice);
		window.setSize(240,250);
		window.setVisible(true);
	}
}
