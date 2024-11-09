import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private NotifPanel notifPanel;

    public Frame() throws IOException {
        // Basic frame setup
        setTitle("Splendor Game");
        setSize(1200, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create and add individual panels
        StartPanel startPanel = new StartPanel(this);
        GamePanel gamePanel = new GamePanel(this);
        EndPanel endPanel = new EndPanel(this);

        mainPanel.add(startPanel, "Start");
        mainPanel.add(gamePanel, "Game");
        mainPanel.add(endPanel, "End");

        // Set the main panel with CardLayout as the content pane
        setContentPane(mainPanel);

        // Initialize the notification panel
        notifPanel = new NotifPanel(this);

        setUndecorated(true);

        // Show the start panel initially
        cardLayout.show(mainPanel, "Start");    }

    // Method to switch panels
    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    // Method to show the notification panel
    public void showNotifPanel(String title, String message) {
        notifPanel.setTitleFont(DataClass.TitleFont.deriveFont(24f));
        notifPanel.setMessageFont(DataClass.TextFont.deriveFont(12f));
        notifPanel.showNotification(title, message);
    }
}
