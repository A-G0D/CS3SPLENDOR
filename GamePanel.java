import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements MouseListener{
    Frame superior;
    int turn;
    public GamePanel(Frame frame) {
        superior = frame;
        GameState gameState = superior.gameState;
        turn = gameState.getTurn();
        gameState.addPlayer();
        gameState.addPlayer();
        gameState.addPlayer();
        gameState.addPlayer();
        setLayout(null);
        JButton quitbutton = createTransparentButton(0, 0, 100, 50);
        quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superior.showNotifPanel("How to Play:", "• Collect gem tokens to buy development cards.\r\n" + 
                                        "• Development cards grant points and bonuses.\r\n" + 
                                        "• Bonuses help attract nobles for points.\r\n" + 
                                        "• On your turn, choose to:\r\n" + 
                                        "\t◦ Take 3 different gems.\r\n" + 
                                        "\t◦ Take 2 of the same gem (if available).\r\n" + 
                                        "\t◦ Buy a card.\r\n" + 
                                        "• First to 15 points wins.");
            }
        });
        add(quitbutton);
        setComponentZOrder(quitbutton, 0);
        addMouseListener(this);
    }

    private JButton createTransparentButton(int x, int y, int width, int height) {
        JButton button = new JButton("X");
        button.setOpaque(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorderPainted(true);
        button.setForeground(Color.WHITE);
        button.setBounds(x, y, width, height);
        return button;
    }

    public void showNotifPanel(String title, String message) {
        superior.showNotifPanel(title, message);
    }

    public void switchPanel(String panel) {
        superior.switchPanel(panel);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = (int) ((double) 3375 / 6000 * getWidth());
        BufferedImage img = DataClass.images.get("Misc").get("gameMainBg").get("00000");
        g.drawImage(img,  0,  0,  width, height, null);
        BufferedImage img2 = DataClass.images.get("Misc").get("gameMainBg").get("00001");
        g.drawImage(img2,  0,  0,  width, height, null);
        BufferedImage img3 = DataClass.images.get("Misc").get("gameMainBg").get("00002");
        System.out.println(width + " " + height);
        width = (int) (615/1.6);
        height = (int) (515/1.6);
        g.drawImage(img3,  (int) (344/1.6) + width * (turn % 2),  (int) (25/1.6) + height * (turn / 2),  width, height, null);
        g.setColor(Color.WHITE);
        g.setFont(DataClass.TitleFont.deriveFont(24f));
        g.drawString("?", 25, 35);
    }

    public void nextTurn() {
        superior.gameState.nextTurn();
        turn = superior.gameState.getTurn();
        repaint();
    }

    public void transactionStarted() {

    }

    public void transactionEnded() {

    }

    public void transactionFinalized() {
        nextTurn();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
