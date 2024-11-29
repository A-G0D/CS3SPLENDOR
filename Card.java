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
