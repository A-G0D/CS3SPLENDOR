import java.util.HashMap;

public class Card {
    private Token.TKN_COLOR color;
    private HashMap<Token, Integer> cost;
    private int points;
    private boolean isReserved, isBought;
    public Card(Token.TKN_COLOR color, HashMap<Token, Integer> cost, int points) {
        this.color = color;
        this.cost = cost;
        this.points = points;
        this.isBought = false;
        this.isReserved = false;
    }
    public Card() {
        cost.put(DataClass.WhiteToken, 0);
        cost.put(DataClass.BlueToken, 0);
        cost.put(DataClass.RedToken, 0);
        cost.put(DataClass.GreenToken, 0);
        cost.put(DataClass.BlackToken, 0);
        color = Token.TKN_COLOR.WHITE;
        points = 0;
    }
    public HashMap<Token, Integer> getCost() {
        return cost;
    }
    public int getPoints() {
        return points;
    }
    public String getColor() {
        return color.toString();
    }
    public Token.TKN_COLOR getColorEnum() {
        return color;
    }
    public void bought() {
        isBought = true;
    }
    public void reserved() {
        isReserved = true;
    }
    public boolean isBought() {
        return isBought;
    }
    public boolean isReserved() {
        return isReserved;
    }
}
