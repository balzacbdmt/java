package Pokedeck;


public class TrainerCard extends Card{
	private static final String cardType = "trainer";
	private String trainerType;
	private String textBox;
	private String trainerRule;
	
	public TrainerCard(String cardName, String imgUrl, int id, String trainerType, String textBox, String trainerRule) {
		super(cardType, cardName, imgUrl, id);
		this.trainerType = trainerType;
		this.textBox = textBox;
		this.trainerRule = trainerRule;
	}

	public String getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(String trainerType) {
		this.trainerType = trainerType;
	}

	public String getTextBox() {
		return textBox;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

	public String getTrainerRule() {
		return trainerRule;
	}

	public void setTrainerRule(String trainerRule) {
		this.trainerRule = trainerRule;
	}

	public static String getCardtype() {
		return cardType;
	}
}
