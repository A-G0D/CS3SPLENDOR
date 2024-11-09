import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadingPanel extends JPanel {
    private BufferedImage loadImg;
    public LoadingPanel() throws IOException {
        loadImg = ImageIO.read(getClass().getResource("Resources\\Misc\\gameLoadBg\\00000\\image.png"));
    }
    public void paint(Graphics g) {
		super.paint(g);
        g.drawImage(loadImg,  0,  0,  getWidth(), (int) ((double) loadImg.getHeight() / loadImg.getWidth() * getWidth()), null);
    }
}
