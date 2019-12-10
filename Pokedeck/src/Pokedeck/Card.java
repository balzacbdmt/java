package Pokedeck;


public abstract class Card {
	private String cardType;
	private String cardName;
	private String imgUrl;
	private int id;
	public Card(String cardType, String cardName, String imgUrl, int id) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.imgUrl = imgUrl;
		this.id = id;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
