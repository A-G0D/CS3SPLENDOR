import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class StartPanel extends JPanel implements MouseListener{
    public JButton startButton, notifButton;
    public StartPanel(Frame frame) {
        
        setLayout(null);

        
        startButton = createTransparentButton((int) (500 * 1440.0/1200), (int) (335 * 1440.0/1200), (int) (200 * 1440.0/1200), (int) (200 * 1440.0/1200));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel("Game");
            }
        });

        
        notifButton = createTransparentButton((int) (1050 * 1440.0/1200), (int) (550 * 1440.0/1200), (int) (150 * 1440.0/1200), (int) (150 * 1440.0/1200));
        notifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showNotifPanel("How to Play:", "• Collect gem tokens to buy development cards.\r\n" + 
                                        "• Development cards grant points and bonuses.\r\n" + 
                                        "• Bonuses help attract nobles for points.\r\n" + 
                                        "• On your turn, choose to:\r\n" + 
                                        "\t◦ Take 3 different gems.\r\n" + 
                                        "\t◦ Take 2 of the same gem (if available).\r\n" + 
                                        "\t◦ Buy a card.\r\n" + 
                                        "• First to 15 points wins.");
            }
        });
        addMouseListener(this);
    }

    private JButton createTransparentButton(int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBounds(x, y, width, height); 
        return button;
    }

    public void paint(Graphics g) {
		super.paint(g);
        BufferedImage img = DataClass.images.get("gameStartBg");
        
//System.out.println(img.getWidth() + " " + img.getHeight());
        g.drawImage(img,  0,  0,  getWidth(), (int) ((double) img.getHeight() / img.getWidth() * getWidth()), null);
        add(startButton);
        add(notifButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println(e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
//System.out.println(e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
//System.out.println(e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
