package Pokedeck;


public class PokemonCard extends Card{
	private static final String cardType = "pokemon";
	private int hp;
	private String type;
	private Attack attackA;
	private Attack attackB;
	
	public PokemonCard(String cardName, String imgUrl, int id, int hp, String type, Attack attackA, Attack attackB) {
		super(cardType, cardName, imgUrl, id);
		this.hp = hp;
		this.type = type;
		this.attackA = attackA;
		this.attackB = attackB;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Attack getAttackA() {
		return attackA;
	}

	public void setAttackA(Attack attackA) {
		this.attackA = attackA;
	}

	public Attack getAttackB() {
		return attackB;
	}

	public void setAttackB(Attack attackB) {
		this.attackB = attackB;
	}

	public static String getCardtype() {
		return cardType;
	}
}
