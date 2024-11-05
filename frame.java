import javax.swing.JFrame;

public class frame extends JFrame{
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 960;
	public frame() {
		super("");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new startPanel());
		setVisible(true);
	}
}
