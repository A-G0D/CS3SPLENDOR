import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifPanel extends JDialog {
    private JLabel titleLabel;
    private JTextArea messageTextArea;

    public NotifPanel(Frame parentFrame) {
        // Setup for the JDialog
        super(parentFrame, "Notification", false); // false makes it non-modal
        setSize(400, 300);
        setLocationRelativeTo(parentFrame); // Centers the dialog relative to the parent frame
        setLayout(new BorderLayout());

        // Create and add the title label
        titleLabel = new JLabel("Notification Title", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Create and add the message text area
        messageTextArea = new JTextArea("This is a detailed notification message.");
        messageTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        messageTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create and add the close button
        JButton closeButton = new JButton("Close");
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(true);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the dialog when clicked
            }
        });

        // Place the button in a corner panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(closeButton);
        buttonPanel.setBackground(new Color(209, 207, 200));
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the dialog undecorated if you want a custom look without default window borders
        setUndecorated(true);

        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(209, 207, 200)));
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        getContentPane().setBackground(new Color(209, 207, 200));

        // Ensure that the dialog can be closed with the 'X' button by default
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    // Method to show the notification panel with custom title and message
    public void showNotification(String title, String message) {
        titleLabel.setText(title);
        messageTextArea.setText(message);
        setVisible(true);
    }

    // Method to set the font of the title
    public void setTitleFont(Font font) {
        titleLabel.setFont(font);
    }

    // Method to set the font of the message text area
    public void setMessageFont(Font font) {
        messageTextArea.setFont(font);
    }
}