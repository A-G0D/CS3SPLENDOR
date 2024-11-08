import java.util.*;
public class Player {
	
	private HashMap<Token, Integer> tokens;
	private ArrayList<Card> cards;
	private ArrayList<Patron> patrons;
	private ArrayList<Card> reserved;
	
	public HashMap<Token, Integer> getTokens(){
		return tokens;
	}
	public ArrayList<Card> getCards(){
		return cards;
	}
	public ArrayList<Patron> getPatrons(){
		return patrons;
	}
	public ArrayList<Card> getReserved(){
		return reserved;
	}
	public int getPoints() {
		int sum = 0;
		for(Card c: cards) {
			sum += c.getPoints();
		}
		for(Patron p: patrons) {
			sum += p.getPoints();
		}
		return sum;
	}
	public void buy(Card c) {
		cards.add(c);
		for(Token t: tokens.keySet()) {
			tokens.put(t, tokens.get(t) - c.getCost().get(t));
		}
	}
	public void reserve(Card c) {
		reserved.add(c);
		Iterator iter = tokens.keySet().iterator();
		for(int i = 0; i < tokens.keySet().size() - 2; i++)
			iter.next();
		Token t = (Token) iter.next();
		tokens.put(t, tokens.get(t) + 1);
	}
	public boolean canBuy(Card c) {
		for(Token t: c.getCost().keySet()) {
			if(tokens.get(t) < c.getCost().get(t))
				return false;
		}
		return true;
	}
	public void loseTokens(HashMap<Token, Integer> t) {
		
	}
	public void addTokens(HashMap<Token, Integer> t) {
	
	}

}
