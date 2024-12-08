import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class EndPanel extends JPanel implements MouseListener{
    public JButton reStartButton;
    public EndPanel(Frame frame) {
        // Set layout to null for absolute positioning
        setLayout(null);

        // Create and configure the restart button
        reStartButton = createTransparentButton(1060, 10, 100, 100);
        reStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel("Start");
            }
        });
        JButton quitbutton = createTransparentButton(0, 0, 100, 50);
        quitbutton.addActionListener(new ActionListener() {
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
        add(quitbutton);
        addMouseListener(this);
    }

    private JButton createTransparentButton(int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBounds(x, y, width, height); // Set position and size
        return button;
    }

    public void paint(Graphics g) {
		super.paint(g);
        BufferedImage img = DataClass.images.get("Misc").get("gameEndBg").get("00000");
        //System.out.println(img.getWidth() + " " + img.getHeight());
        g.drawImage(img,  0,  0,  getWidth(), (int) ((double) img.getHeight() / img.getWidth() * getWidth()), null);
        add(reStartButton);
        g.setColor(Color.WHITE);
        g.setFont(DataClass.TitleFont.deriveFont(24f));
        g.drawString("?", 25, 35);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getX() + ", " + e.getY());
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
