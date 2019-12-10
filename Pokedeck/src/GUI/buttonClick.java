package GUI;

import java.awt.event.ActionEvent;
import Pokedeck.Attack;
import Pokedeck.Card;
import Pokedeck.EnergyCard;
import Pokedeck.Pokedeck;
import Pokedeck.PokemonCard;
import Pokedeck.TrainerCard;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class buttonClick implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton button = (JButton) e.getSource();
	    String command = button.getActionCommand();
	    if (command == "+") {
	    	//Add card
	    	@SuppressWarnings("unused")
			WindowAddPokemon win = new WindowAddPokemon();
	    } else if (command == "-") {
	    	//RM card
	    	Pokedeck.rmCard(BackBoard.idPokemonSelected);
	    } else if (command == "update") {
	    	//Update Card
			Card pOld = Pokedeck.getCard(BackBoard.idPokemonSelected);
	    	String cardType = BackBoard.txtpnTypeCard.getText();
	    	String cardName = BackBoard.txtpnName.getText();
	    	String hp = BackBoard.txtpnHp.getText();
	    	String type = BackBoard.txtpnType.getText();
	    	String nameAt1 = BackBoard.txtpnNameAt1.getText();
	    	String descAt1 = BackBoard.txtpnDescAt1.getText();
	    	String powerAt1 = BackBoard.txtpnPowerAt1.getText();
	    	String nameAt2 = BackBoard.txtpnNameAt2.getText();
	    	String descAt2 = BackBoard.txtpnDescAt2.getText();
	    	String powerAt2 = BackBoard.txtpnPowerAt2.getText();
	    	switch (cardType) {
	    		case "pokemon":
	    			Attack att1 = new Attack(nameAt1, descAt1, Integer.parseInt(powerAt1));
	    			Attack att2 = new Attack(nameAt2, descAt2, Integer.parseInt(powerAt2));
	    			Card pNew = new PokemonCard(cardName, pOld.getImgUrl(), pOld.getId(), Integer.parseInt(hp), type, att1, att2);
	    			Pokedeck.updateCard(BackBoard.idPokemonSelected, pNew);
	    			break;
	    		case "trainer":
                	Card tNew = new TrainerCard(cardName, pOld.getImgUrl(), pOld.getId(), nameAt1, descAt1, powerAt1);
	    			Pokedeck.updateCard(BackBoard.idPokemonSelected, tNew);
	    			break;
	    		case "energy":
                	EnergyCard eNew = new EnergyCard(cardName, pOld.getImgUrl(), pOld.getId(), type);
	    			Pokedeck.updateCard(BackBoard.idPokemonSelected, eNew);
	    			break;
    			default:
    				System.out.println("error !");
	    	}
	    }
	}
}
