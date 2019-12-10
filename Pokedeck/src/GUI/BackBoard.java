package GUI;

import Pokedeck.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class BackBoard extends JPanel{
	static int idPokemonSelected = 55;
	static DefaultListModel<String> listCard = new DefaultListModel<String>();
	JList<String> list = new JList<String>(listCard);
	JButton buttonRm = new JButton("-");
	JButton buttonAdd = new JButton("+");
	static JTextPane txtpnTypeCard = new JTextPane();
	static JTextPane txtpnName = new JTextPane();
	static JTextPane txtpnHp = new JTextPane();
	static JTextPane txtpnType = new JTextPane();
	static JTextPane txtpnNameAt1 = new JTextPane();
	static JTextPane txtpnDescAt1 = new JTextPane();
	static JTextPane txtpnPowerAt1 = new JTextPane();
	static JTextPane txtpnNameAt2 = new JTextPane();
	static JTextPane txtpnDescAt2 = new JTextPane();
	static JTextPane txtpnPowerAt2 = new JTextPane();
	JButton buttonUpdate = new JButton("update");
	
	protected BackBoard() {
		super();
		init();
	}

	private void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		list.setBackground(Color.LIGHT_GRAY);
		fillList();
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
	            int index = list.locationToIndex(evt.getPoint());
	            idPokemonSelected = index;
		        if (evt.getClickCount() == 1) {
		        	if (Pokedeck.getCard(index).getCardType() == "pokemon") {
		        		PokemonCard p = (PokemonCard) Pokedeck.getCard(index);
		        		printScreenPokemon(p);
		        	} else if (Pokedeck.getCard(index).getCardType() == "trainer") {
		        		TrainerCard t = (TrainerCard) Pokedeck.getCard(index);
		        		printScreenTrainer(t);
		        	} else if (Pokedeck.getCard(index).getCardType() == "energy") {
		        		EnergyCard e = (EnergyCard) Pokedeck.getCard(index);
		        		printScreenEnergy(e);
		        	}
		        } else if (evt.getClickCount() == 2) {
		        	System.out.println("test");
		        }
		    }
		});
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 9;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(list, gbc_list);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 9;
		buttonAdd.addActionListener(new buttonClick());
		add(buttonAdd, gbc_button);
		
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 9;
		buttonRm.addActionListener(new buttonClick());
		add(buttonRm, gbc_button_1);

		JPanel infoCard = new JPanel();
		infoCard.setPreferredSize(new Dimension(500, 300));
		infoCard.setLayout(new BoxLayout(infoCard, BoxLayout.Y_AXIS));
		
		txtpnTypeCard.setText("");
		infoCard.add(txtpnTypeCard);
		
		txtpnName.setText("");
		infoCard.add(txtpnName);
		
		txtpnHp.setText("");
		infoCard.add(txtpnHp);
		
		txtpnType.setText("");
		infoCard.add(txtpnType);
		
		txtpnNameAt1.setText("");
		infoCard.add(txtpnNameAt1);
		
		txtpnDescAt1.setText("");
		infoCard.add(txtpnDescAt1);
		
		txtpnPowerAt1.setText("");
		infoCard.add(txtpnPowerAt1);
		
		txtpnNameAt2.setText("");
		infoCard.add(txtpnNameAt2);
		
		txtpnDescAt2.setText("");
		infoCard.add(txtpnDescAt2);
		
		txtpnPowerAt2.setText("");
		infoCard.add(txtpnPowerAt2);

		buttonUpdate.addActionListener(new buttonClick());
		infoCard.add(buttonUpdate);
		
		add(infoCard);
		
		//TODO
		//img
	}
	
	public static void fillList() {
		listCard.clear();
		for(int i = 0; i < Pokedeck.getPokedeck().size(); i++) {
			listCard.addElement(Pokedeck.getPokedeck().get(i).getCardName());
		}
	}

	private void printScreenPokemon(PokemonCard p) {
		txtpnTypeCard.setText(p.getCardType());
		txtpnName.setText(p.getCardName());
		txtpnHp.setText(p.getHp()+"");
		txtpnType.setText(p.getType());
		txtpnNameAt1.setText(p.getAttackA().getName());
		txtpnDescAt1.setText(p.getAttackA().getDesc());
		txtpnPowerAt1.setText(p.getAttackA().getPower()+"");
		txtpnNameAt2.setText(p.getAttackB().getName());
		txtpnDescAt2.setText(p.getAttackB().getDesc());
		txtpnPowerAt2.setText(p.getAttackB().getPower()+"");

	}
	
	private void printScreenTrainer(TrainerCard t) {
		txtpnTypeCard.setText(t.getCardType());
		txtpnName.setText(t.getCardName());
		txtpnHp.setText("");
		txtpnType.setText("");
		txtpnNameAt1.setText(t.getTrainerType());
		txtpnDescAt1.setText(t.getTextBox());
		txtpnPowerAt1.setText(t.getTrainerRule());
		txtpnNameAt2.setText("");
		txtpnDescAt2.setText("");
		txtpnPowerAt2.setText("");
	}
	
	private void printScreenEnergy(EnergyCard e) {
		txtpnName.setText(e.getCardName());
		txtpnTypeCard.setText(e.getCardType());
		txtpnName.setText(e.getCardName());
		txtpnHp.setText("");
		txtpnType.setText(e.getType());
		txtpnNameAt1.setText("");
		txtpnDescAt1.setText("");
		txtpnPowerAt1.setText("");
		txtpnNameAt2.setText("");
		txtpnDescAt2.setText("");
		txtpnPowerAt2.setText("");
	}
}
