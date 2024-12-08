import java.util.HashMap;
import java.util.ArrayList;

public class Player {
    private HashMap<Token, Integer> tokens;
    private ArrayList<Card> cards;
    private ArrayList<Patron> patrons;
    private int points;
    private ArrayList<Card> reserved;
    public Player() {
        tokens = new HashMap<Token, Integer>();
        tokens.put(DataClass.WhiteToken, 0);
        tokens.put(DataClass.BlueToken, 0);
        tokens.put(DataClass.GreenToken, 0);
        tokens.put(DataClass.RedToken, 0);
        tokens.put(DataClass.BlackToken, 0);
        tokens.put(DataClass.GoldToken, 0);
        cards = new ArrayList<Card>();
        patrons = new ArrayList<Patron>();
        points = 0;
        reserved = new ArrayList<Card>();
    }
    public void addToken(Token token, int amount) {
        tokens.put(token, tokens.get(token) + amount);
    }
    public boolean removeToken(Token token, int amount) {
        if (tokens.get(token) >= amount) {
            tokens.put(token, tokens.get(token) - amount);
            return true;
        }
        return false;
    }
    public void addToken(HashMap<Token, Integer> tokens) {
        for (Token token : tokens.keySet()) {
            this.tokens.put(token, this.tokens.get(token) + tokens.get(token));
        }
    }
    public boolean removeToken(HashMap<Token, Integer> tokens) {
        for (Token token : tokens.keySet()) {
            if (this.tokens.get(token) < tokens.get(token)) {
                return false;
            }
        }
        for (Token token : tokens.keySet()) {
            this.tokens.put(token, this.tokens.get(token) - tokens.get(token));
        }
        return true;
    }
    public HashMap<Token, Integer> getTokens() {
        return tokens;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public void removeCard(Card card) {
        cards.remove(card);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }
    public ArrayList<Patron> getPatrons() {
        return patrons;
    }
    public void addPoints(int points) {
        this.points += points;
    }
    public void removePoints(int points) {
        this.points -= points;
    }
    public int getPoints() { //update and return
        for (Card card : cards) {
            points += card.getPoints();
        }
        for (Patron patron : patrons) {
            points += patron.getPoints();
        }
        return points;
    }
    public void addReserved(Card card) {
        reserved.add(card);
        addToken(DataClass.GoldToken, 1);
    }
    public void removeReserved(Card card) {
        reserved.remove(card);
        removeToken(DataClass.GoldToken, 1);
    }
    public ArrayList<Card> getReserved() {
        return reserved;
    }
    public boolean buy(Card card) {
        if (removeToken(card.getCost())) {
            if (card.isReserved()) {
                removeReserved(card);
            } else {
                addCard(card);
            }
            return true;
        }
        return false;
    }
    public boolean canBuy(Card card) { 
        return false;  //work later
    }
    public boolean reserve(Card card) {
        if (reserved.size() < 3) {
            addToken(DataClass.GoldToken, 1);
            addReserved(card);
            return true;
        }
        return false;
    }
    public boolean isValid() {
        int totalTokens = 0;
        for (Token c : tokens.keySet()) {
            totalTokens += tokens.get(c);
        }
        if (totalTokens > 10) {
            return false;
        }
        return true;
    }
}