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
