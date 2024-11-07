import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    public GamePanel(Frame frame) {
        // Set layout to null for absolute positioning
        setLayout(null);

        // Create and configure the end button
        JButton endButton = createTransparentButton(50, 100, 100, 50);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchPanel("End");
            }
        });

        // Create and configure the notification button
        JButton notifButton = createTransparentButton(200, 100, 100, 50);
        notifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showNotifPanel();
            }
        });

        // Add buttons to the panel
        add(endButton);
        add(notifButton);
    }

    private JButton createTransparentButton(int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBounds(x, y, width, height); // Set position and size
        return button;
    }
}
