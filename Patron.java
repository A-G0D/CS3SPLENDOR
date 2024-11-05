import java.util.*;
public class Patron {

	private String person;
	private HashMap<Card, Integer> cost;
	private int pointWorth;
	
	public Patron(String p, HashMap<Card, Integer> ct, int point) {
		person = p;
		cost = ct;
		pointWorth = point;
	}
	public String getPerson() {
		return person;
	}
	public HashMap<Card, Integer> getCost(){
		return cost;
	}
	public int getPoints() {
		return pointWorth;
	}
}
