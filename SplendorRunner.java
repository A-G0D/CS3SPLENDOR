import java.awt.FontFormatException;
import java.io.*;

public class SplendorRunner {
    public static void main(String[] args) throws IOException, FontFormatException{
        LoadingFrame loadingFrame = new LoadingFrame();
        loadingFrame.setVisible(true);
        @SuppressWarnings("unused")
        DataClass DC = new DataClass();
        Frame frame = new Frame();
        frame.setVisible(true);
        //Rudimentary approach to make the program busy and keep the new frame on the screen before making the loading frame disappear
        frame.setVisible(true);
        frame.setVisible(true);
        frame.setVisible(true);
        loadingFrame.setVisible(false);
    }
}


