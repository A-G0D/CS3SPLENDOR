import java.util.*;
public class Card {

	private String color;
	private HashMap<Token, Integer> cost;
	private int pointWorth;
	private int tokenWorth;
	
	public Card(String c, HashMap<Token, Integer> ct, int point, int token) {
		color = c;
		cost = ct;
		pointWorth = point;
		tokenWorth = token;
	}
	
	public String getColor() {
		return color;
	}
	public HashMap<Token, Integer> getCost(){
		return cost;
	}
	public int getPoints() {
		return pointWorth;
	}
	public int getDiscount() {
		return tokenWorth;
	}
}
