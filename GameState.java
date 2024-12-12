import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameState {
    private ArrayList<Player> players;
    private int turn; // 0-indexed (0 = player 1's turn, 1 = player 2's turn...)
    private boolean isLastRound; // switch after someone hits 15
    private HashMap<Token, Integer> tokenDeck;
    private ArrayList<Card> deck1;
    private ArrayList<Card> deck2;
    private ArrayList<Card> deck3;
    Card[] vis1 = new Card[4]; //visible 4 cards level 1
    Card[] vis2 = new Card[4]; //visible 4 cards level 2
    Card[] vis3 = new Card[4]; //visible 4 cards level 3
    Patron[] visNobles = new Patron[5]; //visible 5 patrons
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
        setupCards();
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
        //if islast turn then turn on end game
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
    public Patron[] getVisNobles() {
        return visNobles;
    }

    public void setupCards() {
        int id = 5;
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 3);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 4);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 3);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 4);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.RED,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 3);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 3);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 4);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 3);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 3);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken,0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 4);
            }},
            1,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken,1);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken,0);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken,0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken,0);
                put(DataClass.RedToken, 3);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken,2);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 3);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 0);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 4);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 1);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 1);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 1);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 2);
            }},
            0,
            id++
        ));
        
        deck1.add(new Card( 
            Token.TKN_COLOR.BLUE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 3);
            }},
            0,
            id++
        ));
        





        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 3);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 2);
            }},
            1,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 4);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 1);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 3);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 3);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 6);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            3,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 5);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.GREEN,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 5);
                put(DataClass.GreenToken, 3);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken,6);
            }},
            3,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 5);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken,0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 5);
                put(DataClass.RedToken, 3);
                put(DataClass.BlackToken,0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 1);
                put(DataClass.GreenToken, 4);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken,0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 3);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 3);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken,2);
            }},
            1,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.BLACK,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 3);
                put(DataClass.BlueToken, 2);
                put(DataClass.GreenToken, 2);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            1,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 1);
                put(DataClass.RedToken, 4);
                put(DataClass.BlackToken, 2);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 2);
                put(DataClass.BlueToken, 3);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 3);
                put(DataClass.BlackToken, 0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 3);
                put(DataClass.RedToken, 2);
                put(DataClass.BlackToken, 2);
            }},
            1,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 6);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 0);
                put(DataClass.BlackToken, 0);
            }},
            3,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 5);
                put(DataClass.BlackToken, 0);
            }},
            2,
            id++
        ));
        
        deck2.add(new Card( 
            Token.TKN_COLOR.WHITE,
            new HashMap<>() {{
                put(DataClass.WhiteToken, 0);
                put(DataClass.BlueToken, 0);
                put(DataClass.GreenToken, 0);
                put(DataClass.RedToken, 5);
                put(DataClass.BlackToken, 3);
            }},
            2,
            id++
        ));
        



        Collections.shuffle(deck1);
        Collections.shuffle(deck2);
        Collections.shuffle(deck3);
        drawC1();
        drawC1();
        drawC1();
        drawC1();
        drawC2();
        drawC2();
        drawC2();
        drawC2();
    }
}
