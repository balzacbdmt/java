package Pokedeck;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Pokedeck {
	public static ArrayList<Card> pokedeck = new ArrayList<Card>();
	static String src = "./src/list_pokemon_card.json";

	public Pokedeck() {
		super();
	}
	
	public static void loadPokedeck() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader(src)) {
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            JsonObject jsonObject = new JsonParser().parse(gson.toJson(json)).getAsJsonObject();
            JsonArray listCard = jsonObject.getAsJsonArray("pokedeck");
            for (int i = 0; i < listCard.size(); i++) {
                String cardType = listCard.get(i).getAsJsonObject().get("cardType").getAsString();
                String imgUrl = listCard.get(i).getAsJsonObject().get("imgUrl").getAsString();
                int id = listCard.get(i).getAsJsonObject().get("id").getAsInt();
                String cardName = listCard.get(i).getAsJsonObject().get("cardName").getAsString();
                JsonArray attr = listCard.get(i).getAsJsonObject().get("attr").getAsJsonArray();
                switch (cardType) {
	                case ("pokemon"):
	                	int hp = attr.get(0).getAsJsonObject().get("hp").getAsInt();
	                	String type = attr.get(0).getAsJsonObject().get("type").getAsString();
	                    JsonArray attackList = attr.get(0).getAsJsonObject().get("attack").getAsJsonArray();
	        			ArrayList<Attack> tabAttack = new ArrayList<Attack>();
	                	for (int j = 0; j < attackList.size(); j++) {
		                	String nameAtt = attackList.get(j).getAsJsonObject().get("name").getAsString();
		                	String descAtt = attackList.get(j).getAsJsonObject().get("desc").getAsString();
		                	int powerAtt = attackList.get(j).getAsJsonObject().get("power").getAsInt();
		                	Attack attack = new Attack(nameAtt, descAtt, powerAtt);
		                	tabAttack.add(attack);
	                	}
	                	PokemonCard p = new PokemonCard(cardName, imgUrl, id, hp, type, tabAttack.get(0), tabAttack.get(1));
	                	pokedeck.add(p);
	                	break;
	                case ("trainer"):
	                	String trainerType = attr.get(0).getAsJsonObject().get("trainerType").getAsString();
	                	String textBox = attr.get(0).getAsJsonObject().get("textBox").getAsString();
	                	String trainerRule = attr.get(0).getAsJsonObject().get("trainerRule").getAsString();
	                	TrainerCard t = new TrainerCard(cardName, imgUrl, id, trainerType, textBox, trainerRule);
	                	pokedeck.add(t);
	                	break;
	                case ("energy"):
	                	String typeEnergy = attr.get(0).getAsJsonObject().get("type").getAsString();
	                	EnergyCard e = new EnergyCard(cardName, imgUrl, id, typeEnergy);
	                	pokedeck.add(e);
	                	break;
	                default:
	                	System.out.println("cardType Error !");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void addCard(Card c) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader(src)) {
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            JsonObject jsonObject = new JsonParser().parse(gson.toJson(json)).getAsJsonObject();
            JsonArray listCard = jsonObject.getAsJsonArray("pokedeck");
		    JsonObject newCard = new JsonObject();
			newCard.addProperty("cardType", c.getCardType());
			newCard.addProperty("imgUrl", c.getImgUrl());
			newCard.addProperty("id", c.getId());
			newCard.addProperty("cardName", c.getCardName());
			JsonArray attrNewCard = new JsonArray();
		    JsonObject attrContentNewCard = new JsonObject();
            switch (c.getClass().getName().toString()) {
				case "Pokedeck.PokemonCard":
					PokemonCard p = (PokemonCard) c;
				    attrContentNewCard.addProperty("hp", p.getHp());
				    attrContentNewCard.addProperty("type", p.getType());
					JsonArray attack = new JsonArray();
					JsonObject at1 = new JsonObject();
					at1.addProperty("name", p.getAttackA().getName());
					at1.addProperty("desc", p.getAttackA().getDesc());
					at1.addProperty("power", p.getAttackA().getPower());
					attack.add(at1);
					JsonObject at2 = new JsonObject();
					at2.addProperty("name", p.getAttackB().getName());
					at2.addProperty("desc", p.getAttackB().getDesc());
					at2.addProperty("power", p.getAttackB().getPower());
					attack.add(at2);
					attrContentNewCard.add("attack", attack);
					break;
				case "Pokedeck.TrainerCard":
					TrainerCard t = (TrainerCard) c;
					attrContentNewCard.addProperty("trainerType", t.getTrainerType());
					attrContentNewCard.addProperty("textBox", t.getTextBox());
					attrContentNewCard.addProperty("trainerRule", t.getTrainerRule());
					break;
				case "Pokedeck.EnergyCard":
					EnergyCard e = (EnergyCard) c;
					attrContentNewCard.addProperty("type", e.getType());
					break;
            }
			attrNewCard.add(attrContentNewCard);
			newCard.add("attr", attrNewCard);	    
		    
		    listCard.add(newCard);

			BufferedWriter writer = Files.newBufferedWriter(Paths.get(src));
		    Gson gson2 = new Gson();
		    writer.write(gson2.toJson(jsonObject));
		    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		pokedeck.add(c);
		GUI.BackBoard.fillList();
	}
	
	public static void rmCard(int idCard) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader(src)) {
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            JsonObject jsonObject = new JsonParser().parse(gson.toJson(json)).getAsJsonObject();
            JsonArray listCard = jsonObject.getAsJsonArray("pokedeck");
            for (int i = 0; i < listCard.size(); i++) {
            	if (idCard == i) {
                    listCard.remove(idCard);
            	}
            }
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(src));
		    Gson gson2 = new Gson();
		    writer.write(gson2.toJson(jsonObject));
		    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		pokedeck.remove(idCard);
		GUI.BackBoard.fillList();
	}
	
	public static void updateCard(int index, Card c) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader(src)) {
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            JsonObject jsonObject = new JsonParser().parse(gson.toJson(json)).getAsJsonObject();
            JsonArray listCard = jsonObject.getAsJsonArray("pokedeck");
            for (int i = 0; i < listCard.size(); i++) {
            	if (index == i) {
    				JsonObject eNew = listCard.get(i).getAsJsonObject();
    				eNew.addProperty("cardName", c.getCardName());
    				JsonArray attrTab = listCard.get(i).getAsJsonObject().get("attr").getAsJsonArray();
                	JsonObject attr = attrTab.get(0).getAsJsonObject();
            		switch (c.getClass().getName().toString()) {
            			case "Pokedeck.PokemonCard":
            				PokemonCard p = (PokemonCard) c;
    	                	attr.addProperty("hp", p.getHp());
    	                	attr.addProperty("type", p.getType());
    	    				JsonArray attackTab = attr.get("attack").getAsJsonArray();
    	                	JsonObject at1 = attackTab.get(0).getAsJsonObject();
    	                	at1.addProperty("name", p.getAttackA().getName());
    	                	at1.addProperty("desc", p.getAttackA().getDesc());
    	                	at1.addProperty("power", p.getAttackA().getPower());
    	                	JsonObject at2 = attackTab.get(1).getAsJsonObject();
    	                	at2.addProperty("name", p.getAttackB().getName());
    	                	at2.addProperty("desc", p.getAttackB().getDesc());
    	                	at2.addProperty("power", p.getAttackB().getPower());
            				break;
            			case "Pokedeck.TrainerCard":
            				TrainerCard t = (TrainerCard) c;
    	                	attr.addProperty("trainerType", t.getTrainerType());
    	                	attr.addProperty("textBox", t.getTextBox());
    	                	attr.addProperty("trainerRule", t.getTrainerRule());
            				break;
            			case "Pokedeck.EnergyCard":
            				EnergyCard e = (EnergyCard) c;
    	                	attr.addProperty("type", e.getType());
            				break;
            		}
            	}
            }
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(src));
		    Gson gson2 = new Gson();
		    writer.write(gson2.toJson(jsonObject));
		    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		pokedeck.set(index, c);
		GUI.BackBoard.fillList();
	}
	
	public static ArrayList<Card> getPokedeck() {
		return pokedeck;
	}
	
	public static Card getCard(int index) {
		return pokedeck.get(index);
	}	
}
