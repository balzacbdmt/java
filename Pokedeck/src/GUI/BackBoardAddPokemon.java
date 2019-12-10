package GUI;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import Pokedeck.Attack;
import Pokedeck.Card;
import Pokedeck.EnergyCard;
import Pokedeck.Pokedeck;
import Pokedeck.PokemonCard;
import Pokedeck.TrainerCard;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class BackBoardAddPokemon extends JPanel implements ActionListener{
	JPanel panel = new JPanel();
	//Pokemon
	JTextPane txtpnName = new JTextPane();
	JTextPane txtpnHp = new JTextPane();
	JTextPane txtpnType = new JTextPane();
	JTextPane txtpnNameAt1 = new JTextPane();
	JTextPane txtpnDescAt1 = new JTextPane();
	JTextPane txtpnPowerAt1 = new JTextPane();
	JTextPane txtpnNameAt2 = new JTextPane();
	JTextPane txtpnDescAt2 = new JTextPane();
	JTextPane txtpnPowerAt2 = new JTextPane();
	//Trainer
	JTextPane txtpnNameT = new JTextPane();
	JTextPane txtpnTypeT = new JTextPane();
	JTextPane txtpnTextBoxT = new JTextPane();
	JTextPane txtpnRuleT = new JTextPane();
	//Energy
	JTextPane txtpnNameE = new JTextPane();
	JTextPane txtpnTypeE = new JTextPane();

	public BackBoardAddPokemon() {
		JButton btnNextType = new JButton("prev");
		btnNextType.addActionListener(this);
		add(btnNextType);
		
		JButton btnPrevType = new JButton("next");
		btnPrevType.addActionListener(this);
		add(btnPrevType);
		
		JPanel card1 = new JPanel();
		card1.setPreferredSize(new Dimension(500, 300));
		card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));
		txtpnName.setText("Name");
		txtpnHp.setText("HP");
		txtpnType.setText("Type");
		txtpnNameAt1.setText("Name attack 1");
		txtpnDescAt1.setText("Desc attack 1");
		txtpnPowerAt1.setText("Power  attack 1");
		txtpnNameAt2.setText("Name attack 2");
		txtpnDescAt2.setText("Desc attack 2");
		txtpnPowerAt2.setText("Power attack 2");
		card1.add(new JLabel("New pokémon"));
		card1.add(txtpnName);
		card1.add(txtpnHp);
		card1.add(txtpnType);
		card1.add(new JLabel("Attaque1:"));
		card1.add(txtpnNameAt1);
		card1.add(txtpnDescAt1);
		card1.add(txtpnPowerAt1);
		card1.add(new JLabel("Attaque2:"));
		card1.add(txtpnNameAt2);
		card1.add(txtpnDescAt2);
		card1.add(txtpnPowerAt2);
		JButton btnAddPokemon = new JButton("add a new pokemon");
		btnAddPokemon.addActionListener(this);
		card1.add(btnAddPokemon);
		card1.setBackground(new Color(255,0,0));
		
		JPanel card2 = new JPanel();
		card2.setPreferredSize(new Dimension(500, 300));
		card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));
		txtpnNameT.setText("Name");
		txtpnTypeT.setText("Trainer type");
		txtpnTextBoxT.setText("Text box");
		txtpnRuleT.setText("Trainer rule");
		card2.add(new JLabel("New trainer"));
		card2.add(txtpnNameT);
		card2.add(txtpnTypeT);
		card2.add(txtpnTextBoxT);
		card2.add(txtpnRuleT);
		JButton btnAddTrainer = new JButton("add a new trainer");
		btnAddTrainer.addActionListener(this);
		card2.add(btnAddTrainer);
		card2.setBackground(new Color(0,255,0));
		       
		JPanel card3 = new JPanel();
		card3.setPreferredSize(new Dimension(500, 300));
		card3.setLayout(new BoxLayout(card3, BoxLayout.Y_AXIS));
		txtpnNameE.setText("Name");
		txtpnTypeE.setText("Type");
	   	card3.add(new JLabel("New energy"));
		card3.add(txtpnNameE);
		card3.add(txtpnTypeE);
		JButton btnAddEnergy = new JButton("add a new energy");
		btnAddEnergy.addActionListener(this);
		card3.add(btnAddEnergy);
		card3.setBackground(new Color(0,0,255));
      
	    panel = new JPanel(new CardLayout());
	    panel.add(card1);
	    panel.add(card2);
	    panel.add(card3);
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.anchor = GridBagConstraints.NORTHWEST;
	    gbc_panel.gridwidth = 2;
  	    gbc_panel.gridx = 0;
	    gbc_panel.gridy = 1;
	    add(panel, gbc_panel);
	}
	
	public  void    actionPerformed(ActionEvent e) { 
		CardLayout cl = (CardLayout) (panel.getLayout());
		//cl.next(panel);
	    JButton button = (JButton) e.getSource();
	    String command = button.getActionCommand();
	    switch(command) {
	    	case "next":
	    		cl.next(panel);
	    		break;
	    	case "prev":
	    		cl.previous(panel);
	    		break;
	    	case "add a new pokemon":
    			Attack att1 = new Attack(txtpnNameAt1.getText(), txtpnDescAt1.getText(), Integer.parseInt(txtpnPowerAt1.getText()));
    			Attack att2 = new Attack(txtpnNameAt2.getText(), txtpnDescAt2.getText(), Integer.parseInt(txtpnPowerAt2.getText()));
    			Card pNew = new PokemonCard(txtpnName.getText(), "", Pokedeck.getPokedeck().size(), Integer.parseInt(txtpnHp.getText()), txtpnType.getText(), att1, att2);
				try {
					Pokedeck.addCard(pNew);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		break;
	    	case "add a new trainer":
	    		Card tNew = new TrainerCard(txtpnNameT.getText(), "", Pokedeck.getPokedeck().size(), txtpnTypeT.getText(), txtpnTextBoxT.getText(), txtpnRuleT.getText());
				try {
					Pokedeck.addCard(tNew);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		break;
	    	case "add a new energy":
            	EnergyCard eNew = new EnergyCard(txtpnNameE.getText(), "", Pokedeck.getPokedeck().size(), txtpnTypeE.getText());
				try {
					Pokedeck.addCard(eNew);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		break;
	    }
    }
}
