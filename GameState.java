import java.util.ArrayList;
import java.util.HashMap;

public class GameState {
    private ArrayList<Player> players;
    private int turn; // 0-indexed (0 = player 1's turn, 1 = player 2's turn...)
    private boolean isLastRound; // switch after someone hits 15
    private HashMap<Token, Integer> tokenDeck;
    private ArrayList<Card> deck1;
    private ArrayList<Card> deck2;
    private ArrayList<Card> deck3;
    private Card[] vis1 = new Card[4];
    private Card[] vis2 = new Card[4];
    private Card[] vis3 = new Card[4];
    private ArrayList<Patron> nobles;
    private Patron[] visNobles = new Patron[5];
    public GameState() {
        players = new ArrayList<Player>();
        turn = 0;
        isLastRound = false;
        tokenDeck = new HashMap<Token, Integer>();
        tokenDeck.put(DataClass.WhiteToken, 7);
        tokenDeck.put(DataClass.BlueToken, 7);
        tokenDeck.put(DataClass.GreenToken, 7);
        tokenDeck.put(DataClass.RedToken, 7);
        tokenDeck.put(DataClass.BlackToken, 7);
        tokenDeck.put(DataClass.GoldToken, 5);
        deck1 = new ArrayList<Card>();
        deck2 = new ArrayList<Card>();
        deck3 = new ArrayList<Card>();
        nobles = new ArrayList<Patron>();
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public void addPlayer() {
        players.add(new Player());
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public int getTurn() {
        return turn;
    }
    public void nextTurn() {
        turn = (turn + 1) % players.size();
    }
    public boolean isLastRound() {
        for (Player i : players) {
            if (i.getPoints() >= 15) {
                isLastRound = true;
                return isLastRound;
            }
        }
        return isLastRound;
    }
    public HashMap<Token, Integer> getTokenDeck() {
        return tokenDeck;
    }
    public ArrayList<Card> getDeck1() {
        return deck1;
    }
    public ArrayList<Card> getDeck2() {
        return deck2;
    }
    public ArrayList<Card> getDeck3() {
        return deck3;
    }
    public Card[] getVis1() {
        return vis1;
    }
    public Card[] getVis2() {
        return vis2;
    }
    public Card[] getVis3() {
        return vis3;
    }
    public void drawC1() {
        for (int i = 0; i < 4; i++) {
            if (vis1[i] == null) {
                vis1[i] = deck1.remove(0);
            }
        }
    }
    public void drawC2() {
        for (int i = 0; i < 4; i++) {
            if (vis2[i] == null) {
                vis2[i] = deck2.remove(0);
            }
        }
    }
    public void drawC3() {
        for (int i = 0; i < 4; i++) {
            if (vis3[i] == null) {
                vis3[i] = deck3.remove(0);
            }
        }
    }
    public ArrayList<Patron> getNobles() {
        return nobles;
    }
    public Patron[] getVisNobles() {
        return visNobles;
    }
    public void drawNobles() {
        for (int i = 0; i < 5; i++) {
            if (visNobles[i] == null) {
                visNobles[i] = nobles.remove(0);
            }
        }
    }
}
