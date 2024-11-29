public class Token {
    public static enum TKN_COLOR {
        WHITE,
        BLUE,
        GREEN,
        RED,
        BLACK,
        GOLD
    }
    private TKN_COLOR color;
    public Token() {
        color = TKN_COLOR.WHITE;
    }
    public Token(TKN_COLOR color) {
        this.color = color;
    }
    public void setColor(TKN_COLOR color) {
        this.color = color;
    }
    public String getColor() {
        return color.toString();
    }
    public TKN_COLOR getColorEnum() {
        return color;
    }
}
