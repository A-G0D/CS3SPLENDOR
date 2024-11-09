import java.io.IOException;

import javax.swing.*;

public class LoadingFrame extends JFrame{
	public LoadingFrame() throws IOException{
		super("Loading");
        setSize(1200, 675);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LoadingPanel());
        setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}
}
