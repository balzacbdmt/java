import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class buttonClick implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton button = (JButton) e.getSource();
	    String command = button.getActionCommand();
	    if (isNumeric(command)) {
	    	Main.textField.setText(Main.textField.getText()+command);
	    } else if(command != "=") {
	    	Main.memoireCalc = Integer.parseInt(Main.textField.getText());
	    	Main.operateur = command;
	    	Main.textField.setText("");
	    } else if(command == "="){
	    	float result = 0;
	    	if (Main.operateur == "+") {
	    		float nb1 = Integer.parseInt(Main.textField.getText());
	    		result = Main.memoireCalc+nb1;
	    		Main.screen.setText(""+result);
	    	} else if(Main.operateur == "-") {
	    		float nb1 = Integer.parseInt(Main.textField.getText());
	    		result = Main.memoireCalc-nb1;
	    		Main.screen.setText(""+result);
	    	} else if(Main.operateur == "*") {
	    		float nb1 = Integer.parseInt(Main.textField.getText());
	    		result = Main.memoireCalc*nb1;
	    		Main.screen.setText(""+result);
	    	} else if(Main.operateur == "/") {
	    		float nb1 = Integer.parseInt(Main.textField.getText());
	    		result = Main.memoireCalc/nb1;
	    		Main.screen.setText(""+result);
	    	} else if(command == "res") {
		    	Main.operateur = "";
		    	Main.textField.setText("");
		    	Main.screen.setText("");
		    	Main.memoireCalc = 0;
		    }
	    }
	}

	public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
}
