import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifPanel extends JDialog {
    public NotifPanel(Frame parentFrame) {
        // Setup for the JDialog
        super(parentFrame, "Notification", false); // false makes it non-modal
        setSize(300, 150);
        setLocationRelativeTo(parentFrame); // Centers the dialog relative to the parent frame
        setLayout(new BorderLayout());

        // Create content for the dialog
        JLabel messageLabel = new JLabel("This is a notification!", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        // Create and add the close button
        JButton closeButton = new JButton("X");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the dialog when clicked
            }
        });

        // Place the button in a corner panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Make the dialog undecorated if you want a custom look without default window borders
        // setUndecorated(true);

        // Ensure that the dialog can be closed with the 'X' button by default
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    // Method to show the notification panel
    public void showNotification() {
        setVisible(true);
    }
}
