import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;

public class GamePanel extends JPanel implements MouseListener{
    Frame superior;
    int turn;
    GameState gameState;    
    HashMap<Token, Integer> purchase = new HashMap<Token, Integer>();
    public GamePanel(Frame frame) {
        
        purchase.put(DataClass.GoldToken, 0);
        purchase.put(DataClass.RedToken, 0);
        purchase.put(DataClass.GreenToken, 0);
        purchase.put(DataClass.WhiteToken, 0);
        purchase.put(DataClass.BlackToken, 0);
        purchase.put(DataClass.BlueToken, 0);
        superior = frame;
        gameState = superior.gameState;
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
                                        "• First to 15 points wins.\r\n" +
                                        "• Right Click to reserve a card.\r\n" + 
                                        "• Click on a card to buy it.");
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
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int width = getWidth();
        int height = (int) ((double) 3375 / 6000 * getWidth());
        BufferedImage img = DataClass.images.get("gameMainBg");
        g.drawImage(img,  0,  0,  width, height, null);
        BufferedImage img2 = DataClass.images.get("gameMainBg1");
        g.drawImage(img2,  0,  0,  width, height, null);
        BufferedImage img3 = DataClass.images.get("gameMainBg2");
        width = (int) (615/1.6 * 1440./1200);
        height = (int) (515/1.6 * 1440./1200);
        g.drawImage(img3,  (int) (344/1.6 * 1440./1200) + width * (turn % 2),  (int) (25/1.6 * 1440./1200) + height * (turn / 2),  width, height, null);
        BufferedImage img4 = DataClass.images.get("gameMainBg3");
        width = (int) (750*.75);
        height = (int) (600*.75);
        g.drawImage(img4, getWidth()/2 - width/2, getHeight()/2-height/2, width, height, null);
        width = 75;
        height = 110;
        BufferedImage c11 = DataClass.getImage("Cards", "" + gameState.vis1[0].id, "00000");
        Image temp = c11.getScaledInstance(width, height, Image.SCALE_FAST);
        g.drawImage(temp,  555,  509,  width, height, null);
        BufferedImage c12 = DataClass.getImage("Cards", "" + gameState.vis1[1].id, "00000");
        temp = c12.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+width+2,  509,  width, height, null);
        BufferedImage c13 = DataClass.getImage("Cards", "" + gameState.vis1[2].id, "00000");
        temp = c13.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+2*(width + 2),  509,  width, height, null);
        BufferedImage c14 = DataClass.getImage("Cards", "" + gameState.vis1[3].id, "00000");
        temp = c14.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+3*(width+2),  509,  width, height, null);

        BufferedImage c21 = DataClass.getImage("Cards", "" + gameState.vis2[0].id, "00000");
        temp = c21.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555,  394,  width, height, null);
        BufferedImage c22 = DataClass.getImage("Cards", "" + gameState.vis2[1].id, "00000");
        temp = c22.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+width+2,  394,  width, height, null);
        BufferedImage c23 = DataClass.getImage("Cards", "" + gameState.vis2[2].id, "00000");
        temp = c23.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+2*(width + 2),  394,  width, height, null);
        BufferedImage c24 = DataClass.getImage("Cards", "" + gameState.vis2[3].id, "00000");
        temp = c24.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(temp,  555+3*(width+2),  394,  width, height, null);

        g.setFont(DataClass.TitleFont.deriveFont(12f));
        g.setColor(Color.BLACK);

        BufferedImage ctg = DataClass.getImage("Tokens", "GoldToken", "00000");
        temp = ctg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270,  190, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.GoldToken),  270 + 50,  190 + 20);
        g.drawImage(temp,  getWidth() - 270- 150,  190, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.GoldToken),  getWidth() - 270- 150 + 50,  190 + 20);
        g.drawImage(temp,  270,  getHeight() - 190 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.GoldToken),  270 + 50,  getHeight() - 190 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150,  getHeight() - 190 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.GoldToken),  getWidth() - 270 - 150 + 50,  getHeight() - 190 - 140 + 100 + 20);
        BufferedImage ctw = DataClass.getImage("Tokens", "WhiteToken", "00000");
        temp = ctw.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270 + 80,  190, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.WhiteToken),  270 + 80 + 50,  190 + 20);
        g.drawImage(temp,  getWidth() - 270- 150 + 80,  190, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.WhiteToken),  getWidth() - 270- 150 + 80 + 50,  190 + 20);
        g.drawImage(temp,  270 + 80,  getHeight() - 190 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.WhiteToken),  270 + 80 + 50,  getHeight() - 190 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150 + 80,  getHeight() - 190 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.WhiteToken),  getWidth() - 270 - 150 + 80 + 50,  getHeight() - 190 - 140 + 100 + 20);
        BufferedImage ctb = DataClass.getImage("Tokens", "BlackToken", "00000");
        temp = ctb.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270,  240, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.BlackToken),  270 + 50,  240 + 20);
        g.drawImage(temp,  getWidth() - 270- 150,  240, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.BlackToken),  getWidth() - 270- 150 + 50,  240 + 20);
        g.drawImage(temp,  270,  getHeight() - 240 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.BlackToken),  270 + 50,  getHeight() - 240 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150,  getHeight() - 240 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.BlackToken),  getWidth() - 270 - 150 + 50,  getHeight() - 240 - 140 + 100 + 20);
        BufferedImage ctr = DataClass.getImage("Tokens", "RedToken", "00000");
        temp = ctr.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270 + 80,  240, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.RedToken),  270 + 80 + 50,  240 + 20);
        g.drawImage(temp,  getWidth() - 270- 150 + 80,  240, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.RedToken),  getWidth() - 270- 150 + 80 + 50,  240 + 20);
        g.drawImage(temp,  270 + 80,  getHeight() - 240 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.RedToken),  270 + 80 + 50,  getHeight() - 240 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150 + 80,  getHeight() - 240 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.RedToken),  getWidth() - 270 - 150 + 80 + 50,  getHeight() - 240 - 140 + 100 + 20);
        BufferedImage ctgr = DataClass.getImage("Tokens", "GreenToken", "00000");
        temp = ctgr.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270,  290, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.GreenToken),  270 + 50,  290 + 20);
        g.drawImage(temp,  getWidth() - 270- 150,  290, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.GreenToken),  getWidth() - 270- 150 + 50,  290 + 20);
        g.drawImage(temp,  270,  getHeight() - 290 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.GreenToken),  270 + 50,  getHeight() - 290 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150,  getHeight() - 290 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.GreenToken),  getWidth() - 270 - 150 + 50,  getHeight() - 290 - 140 + 100 + 20);
        BufferedImage ctbl = DataClass.getImage("Tokens", "BlueToken", "00000");
        temp = ctbl.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        g.drawImage(temp,  270 + 80,  290, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(0).getTokens().get(DataClass.BlueToken),  270 + 80 + 50,  290 + 20);
        g.drawImage(temp,  getWidth() - 270- 150 + 80,  290, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(1).getTokens().get(DataClass.BlueToken),  getWidth() - 270- 150 + 80 + 50,  290 + 20);
        g.drawImage(temp,  270 + 80,  getHeight() - 290 - 140 + 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(2).getTokens().get(DataClass.BlueToken),  270 + 80 + 50,  getHeight() - 290 - 140 + 100 + 20);
        g.drawImage(temp,  getWidth() - 270 - 150 + 80,  getHeight() - 290 - 140+ 100, 50, 50, null);
        g.drawString("" + gameState.getPlayers().get(3).getTokens().get(DataClass.BlueToken),  getWidth() - 270 - 150 + 80 + 50,  getHeight() - 290 - 140+ 100 + 20);

        
        g.setColor(Color.WHITE);
        g.setFont(DataClass.TitleFont.deriveFont(24f));
        g.drawString("?", 25, 35);
        g.setColor(Color.BLACK);
        g.setFont(DataClass.TitleFont.deriveFont(14f)); 
        g.drawString("" + gameState.getPlayers().get(0).getPoints(), (int)(231 * 1440./1200), (int)(300 * 1440./1200));
        g.drawString("" + gameState.getPlayers().get(1).getPoints(), (int)(getWidth() - 1440./1200 *251), (int)(300 * 1440./1200));
        g.drawString("" + gameState.getPlayers().get(2).getPoints(), (int)(231 * 1440./1200), (int)((getHeight()*1200./1400 - 300)*1440./1200));
        g.drawString("" + gameState.getPlayers().get(3).getPoints(), (int)(getWidth() - 1440./1200 *251), (int)((getHeight()*1200./1400 - 300)*1440./1200));
    
        g.drawString("" + gameState.getTokenDeck().get(DataClass.GoldToken), 966, 222);
        int space = 66;
        g.drawString("" + gameState.getTokenDeck().get(DataClass.RedToken), 966, 222 + space);
        g.drawString("" + gameState.getTokenDeck().get(DataClass.GreenToken), 966, 222 + 2*space);
        g.drawString("" + gameState.getTokenDeck().get(DataClass.WhiteToken), 966, 222 + 3*space);
        g.drawString("" + gameState.getTokenDeck().get(DataClass.BlackToken), 966, 222 + 4*space);
        g.drawString("" + gameState.getTokenDeck().get(DataClass.BlueToken), 966, 222 + 5*space);
    }

    public void nextTurn() {
        superior.gameState.nextTurn();
        turn = superior.gameState.getTurn();
        repaint();
    }

    public void transactionFinalized() {
        purchase.put(DataClass.GoldToken, 0);
        purchase.put(DataClass.RedToken, 0);
        purchase.put(DataClass.GreenToken, 0);
        purchase.put(DataClass.WhiteToken, 0);
        purchase.put(DataClass.BlackToken, 0);
        purchase.put(DataClass.BlueToken, 0);
        nextTurn();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
        boolean valid = true;;
        boolean isLeft = e.getButton() == 1;
        if (x > 555 && x < 555 + 4 * 76 && y < 620 && y > 620 - 3*115) {
            int col = (e.getX() - 555)/76;
            int row = -(e.getY() - 620)/115;
            System.out.println(row + " " + col);
            switch (row) {
                case 0:
                    if (isLeft) {
                        if (gameState.getPlayers().get(turn).canBuy(gameState.vis1[col])) {
                            gameState.getPlayers().get(turn).buy(gameState.vis1[col]);
                            transactionFinalized();
                        }
                        else {
                            superior.showNotifPanel("Invalid Move", "You do not have enough tokens to buy this card.");
                            valid = false;
                            for (Token tk : gameState.getPlayers().get(turn).getTokens().keySet()) {
                                System.out.println(tk.getColor() + " " + purchase.get(tk));
                            }
                            System.out.println();
                            for (Token tk : gameState.vis1[col].getCost().keySet()) {
                                System.out.println(tk.getColor() + " " + purchase.get(tk));
                            }
                            System.out.println(gameState.getPlayers().get(turn).canBuy(gameState.vis1[col]));
                        }
                    } else {
                        gameState.getPlayers().get(turn).reserve(gameState.vis1[col]);
                        transactionFinalized();
                    }
                    break;
                case 1:
                    if (isLeft) {
                        if (gameState.getPlayers().get(turn).canBuy(gameState.vis2[col])) {
                            gameState.getPlayers().get(turn).buy(gameState.vis2[col]);
                            transactionFinalized();
                        }

                        else {
                            superior.showNotifPanel("Invalid Move", "You do not have enough tokens to buy this card.");
                            valid = false;
                        }
                    } else {
                     gameState.getPlayers().get(turn).reserve(gameState.vis2[col]);
                     transactionFinalized();
                    }
                    break;
                case 2:
                    if (isLeft) {
                        if (gameState.getPlayers().get(turn).canBuy(gameState.vis3[col])) {
                            gameState.getPlayers().get(turn).buy(gameState.vis3[col]);
                            transactionFinalized();
                        }

                        else {
                            superior.showNotifPanel("Invalid Move", "You do not have enough tokens to buy this card.");
                            valid = false;
                        }
                    } else {
                        gameState.getPlayers().get(turn).reserve(gameState.vis3[col]);
                        transactionFinalized();
                    }
                    break;
                default:
                    System.out.println("sm wrong");
                    break;
            }

        } else if (x > 900 && x < 970 && y > 224 && y < 224 + 6*66) {
            int tkn = (y-224)/66;
            Token token = null;
            switch (tkn) {
                case 0:
                    superior.showNotifPanel("Invalid Move", "Cannot purchase gold coins directly. Reserve a card");
                    valid = false;
                    break;
                case 1:
                    if (gameState.getTokenDeck().get(DataClass.RedToken) == 0) {
                        superior.showNotifPanel("Invalid Move", "There are no red tokens left.");
                        valid = false;
                        break;
                    }
                    purchase.put(DataClass.RedToken, purchase.get(DataClass.RedToken) + 1);
                    token = DataClass.RedToken;
                    break;
                case 2:
                    if (gameState.getTokenDeck().get(DataClass.GreenToken) == 0) {
                        superior.showNotifPanel("Invalid Move", "There are no green tokens left.");
                        valid = false;
                        break;
                    }
                    purchase.put(DataClass.GreenToken, purchase.get(DataClass.GreenToken) + 1);
                    token = DataClass.GreenToken;
                    break;  
                case 3:
                    if (gameState.getTokenDeck().get(DataClass.WhiteToken) == 0) {
                        superior.showNotifPanel("Invalid Move", "There are no white tokens left.");
                        valid = false;
                        break;
                    }
                    purchase.put(DataClass.WhiteToken, purchase.get(DataClass.WhiteToken) + 1);
                    token = DataClass.WhiteToken;
                    break;
                case 4:
                    if (gameState.getTokenDeck().get(DataClass.BlackToken) == 0) {
                        superior.showNotifPanel("Invalid Move", "There are no black tokens left.");
                        valid = false;
                        break;
                    }
                    purchase.put(DataClass.BlackToken, purchase.get(DataClass.BlackToken) + 1);
                    token = DataClass.BlackToken;
                    break;
                case 5:
                    if (gameState.getTokenDeck().get(DataClass.BlueToken) == 0) {
                        superior.showNotifPanel("Invalid Move", "There are no blue tokens left.");
                        valid = false;
                        break;
                    }
                    purchase.put(DataClass.BlueToken, purchase.get(DataClass.BlueToken) + 1);
                    token = DataClass.BlueToken;
                    break;
                default:
                    System.out.println("sm wrong");
                    break;
            }
            int sum = 0;
            for (int i : purchase.values()) {
                sum += i;
            }
            for (Token t : purchase.keySet()) {
                if (sum > 3) {
                    superior.showNotifPanel("Invalid Move", "You cannot purchase more than 3 tokens in a turn.");
                    valid = false;
                    transactionFinalized();
                    break;
                }
                else if (purchase.get(t) > 2) {
                    superior.showNotifPanel("Invalid Move", "You cannot purchase more than 2 tokens of the same type.");
                    valid = false;
                    transactionFinalized();
                    break;
                }
            }
            if (valid) {
                gameState.getPlayers().get(turn).addToken(token, 1);
                gameState.getTokenDeck().put(token, gameState.getTokenDeck().get(token) - 1);
                repaint();
            }
        }
        repaint();
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
