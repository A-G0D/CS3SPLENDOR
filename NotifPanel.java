import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NotifPanel extends JDialog {
    private JLabel titleLabel;
    private JTextArea messageTextArea;

    public NotifPanel(Frame parentFrame) {
        super(parentFrame, "Notification", false); 
        setSize(400, 300);
        setLocationRelativeTo(parentFrame); 
        setLayout(new BorderLayout());

        
        titleLabel = new JLabel("Notification Title", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        
        messageTextArea = new JTextArea("This is a detailed notification message.");
        messageTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        messageTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        add(scrollPane, BorderLayout.CENTER);

        
        JButton closeButton = new JButton("Close Window");
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(true);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); 
            }
        });

        JButton quitButton = new JButton("Quit App");
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(true);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(quitButton);
        buttonPanel.add(closeButton);
        buttonPanel.setBackground(new Color(209, 207, 200));
        add(buttonPanel, BorderLayout.SOUTH);
        

        
        setUndecorated(true);

        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(209, 207, 200)));
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        getContentPane().setBackground(new Color(209, 207, 200));

        
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    
    public void showNotification(String title, String message) {
        titleLabel.setText(title);
        messageTextArea.setText(message);
        setVisible(true);
    }

    
    public void setTitleFont(Font font) {
        titleLabel.setFont(font);
    }

    
    public void setMessageFont(Font font) {
        messageTextArea.setFont(font);
    }
}