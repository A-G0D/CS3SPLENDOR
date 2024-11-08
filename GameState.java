import java.util.*;

public class GameState {
	private ArrayList<Player> players;
	private int turn;
	private boolean lastRound;
	private ArrayList<Token> tokenDeck;
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> deck3;
	private ArrayList<Patron> patronDeck;
	
	public GameState(ArrayList<Player> p, int t, boolean lR, ArrayList<Token> tD, ArrayList<Card> d1, ArrayList<Card> d2, ArrayList<Card> d3, ArrayList<Patron> pD) {
		players = p;
		lastRound = lR;
		tokenDeck = tD;
		deck1 = d1;
		deck2 = d2;
		deck3 = d3;
		patronDeck = pD;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public ArrayList<Token> getTD() {
		return tokenDeck;
	}
	
	public ArrayList<Card> getD1() {
		return deck1;
	}
	
	public ArrayList<Card> getD2() {
		return deck2;
	}
	
	public ArrayList<Card> getD3() {
		return deck3;
	}
	
	public ArrayList<Patron> getPD() {
		return patronDeck;
	}
}
