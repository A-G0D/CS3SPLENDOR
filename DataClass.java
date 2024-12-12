import java.util.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public class DataClass {
    public static TreeMap<String, TreeMap<String, TreeMap<String, String>>> imagePaths = new TreeMap<>();
    public static Font TitleFont, TextFont;
    public static Token WhiteToken, BlueToken, GreenToken, RedToken, BlackToken, GoldToken;
    public static TreeMap<String, BufferedImage> images = new TreeMap<>();

    public DataClass() throws IOException, FontFormatException {
        images.put("gameMainBg", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameMainBg/00000/image.png")));
        images.put("gameMainBg1", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameMainBg/00001/image.png")));
        images.put("gameMainBg2", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameMainBg/00002/image.png")));
        images.put("gameMainBg3", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameMainBg/00003/image.png")));
        images.put("gameLoadBg", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameLoadBg/00000/image.png")));
        images.put("gameEndBg", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameEndBg/00000/image.png")));
        images.put("gameStartBg", ImageIO.read(DataClass.class.getResource("/Resources/Misc/gameStartBg/00000/image.png")));
        String[] folders = new String[]{"Cards", "Misc", "Patrons", "Tokens"};

        for (String folder : folders) {
            imagePaths.put(folder, new TreeMap<>());

            URL folderURL = DataClass.class.getResource("/Resources/" + folder);
            if (folderURL == null) {
                System.out.println("Resource folder not found: /Resources/" + folder);
                continue;
            }

            File folderFile = new File(folderURL.getPath());
            if (!folderFile.isDirectory()) {
                System.out.println("Not a directory: " + folderFile);
                continue;
            }

            // List subfolders
            File[] subfolders = folderFile.listFiles(File::isDirectory);
            if (subfolders == null) continue;

            for (File subfolder : subfolders) {
                String subfolderName = subfolder.getName();
                imagePaths.get(folder).put(subfolderName, new TreeMap<>());

                // List subsubfolders
                File[] subsubfolders = subfolder.listFiles(File::isDirectory);
                if (subsubfolders == null) continue;

                for (File subsubfolder : subsubfolders) {
                    String subsubfolderName = subsubfolder.getName();
                    String imagePath = "/Resources/" + folder + "/" + subfolderName + "/" + subsubfolderName + "/image.png";

                    // Store the file path
                    imagePaths.get(folder).get(subfolderName).put(subsubfolderName, imagePath);
                    System.out.println("Path stored: " + imagePath);
                }
            }
        }

        // Load fonts
        try (InputStream titleFontStream = DataClass.class.getResourceAsStream("/TitleFont.ttf");
             InputStream textFontStream = DataClass.class.getResourceAsStream("/TextFont.ttf")) {
            if (titleFontStream == null || textFontStream == null) {
                throw new FileNotFoundException("Font files not found in resources.");
            }
            TitleFont = Font.createFont(Font.TRUETYPE_FONT, titleFontStream);
            TextFont = Font.createFont(Font.TRUETYPE_FONT, textFontStream);
        }

        // Initialize Tokens
        WhiteToken = new Token(Token.TKN_COLOR.WHITE);
        BlueToken = new Token(Token.TKN_COLOR.BLUE);
        GreenToken = new Token(Token.TKN_COLOR.GREEN);
        RedToken = new Token(Token.TKN_COLOR.RED);
        BlackToken = new Token(Token.TKN_COLOR.BLACK);
        GoldToken = new Token(Token.TKN_COLOR.GOLD);
    }

    // Method to load an image on demand
    /*public static BufferedImage getImage(String folder, String subfolder, String subsubfolder) {
        String path = imagePaths.get(folder).get(subfolder).get(subsubfolder);
        if (path == null) {
            System.out.println("Image path not found: " + folder + "/" + subfolder + "/" + subsubfolder);
            return null;
        }

        try (InputStream is = DataClass.class.getResourceAsStream(path)) {
            if (is == null) {
                System.out.println("Image file not found: " + path);
                return null;
            }
            return ImageIO.read(is);
        } catch (IOException e) {
            System.out.println("Failed to load image: " + path);
            e.printStackTrace();
            return null;
        }
    }*/
    public static BufferedImage getImage(String folder, String subfolder, String subsubfolder) {
        String imagePath = "/Resources/" + folder + "/" + subfolder + "/" + subsubfolder + "/image.png";
        try (InputStream is = DataClass.class.getResourceAsStream(imagePath)) {
            if (is == null) {
                System.out.println("Image file not found: " + imagePath);
                return null;
            }
            return ImageIO.read(is);
        } catch (IOException e) {
            System.out.println("Failed to load image: " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
}
