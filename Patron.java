import java.util.HashMap;

public class Patron {
    private int nobleID;
    private HashMap<Card, Integer> cost;
    private int points;
    public Patron(int nobleID, HashMap<Card, Integer> cost, int points) {
        this.nobleID = nobleID;
        this.cost = cost;
        this.points = points;
    }
    public HashMap<Card, Integer> getCost() {
        return cost;
    }
    public int getPoints() {
        return points;
    }
    public int getNobleID() {
        return nobleID;
    }
}
