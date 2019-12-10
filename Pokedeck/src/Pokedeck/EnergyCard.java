package Pokedeck;


public class EnergyCard extends Card{
	private static final String cardType = "energy";
	private String type;
	
	public EnergyCard(String cardName, String imgUrl, int id, String type) {
		super(cardType, cardName, imgUrl, id);
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static String getCardtype() {
		return cardType;
	}	
}
