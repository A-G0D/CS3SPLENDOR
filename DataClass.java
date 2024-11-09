import java.util.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class DataClass {
    public static TreeMap<String, TreeMap<String, TreeMap<String, BufferedImage>>> images = new TreeMap<String, TreeMap<String, TreeMap<String, BufferedImage>>>();
    public static Font TitleFont, TextFont;
    public DataClass() throws IOException, FontFormatException{
        String[] folders = new String[]{"Cards", "Misc", "Patrons", "Tokens"};
        for (String folder : folders){
            //System.out.println(folder);
            File folder1 = new File(getClass().getResource("/Resources/" + folder).toString().substring(6));
            //System.out.println(" " + folder1 + " " + folder1.isDirectory());
            File subfoldersf[] = folder1.listFiles();
            String[] subfolders = new String[subfoldersf.length];
            for (int i = 0; i < subfoldersf.length; i++) {
                subfolders[i] = subfoldersf[i].getName();
            }
            images.put(folder, new TreeMap<String, TreeMap<String, BufferedImage>>());
            for (String subfolder : subfolders) {
                //System.out.println(folder + " " + subfolder);
                File folder2 = new File(getClass().getResource("/Resources/" + folder + "/" + subfolder).toString().substring(6));
                File subsubfoldersf[] = folder2.listFiles();
                String[] subsubfolders = new String[subsubfoldersf.length];
                for (int i = 0; i < subsubfoldersf.length; i++) {
                    subsubfolders[i] = subsubfoldersf[i].getName();
                }           
                images.get(folder).put(subfolder, new TreeMap<String, BufferedImage>());
                for (String subsubfolder : subsubfolders) {
                        //System.out.println(folder + " " + subfolder + " " + subsubfolder);
                        //File tmpFile = new File(getClass().getResource("/Resources/" + folder + "/" + subfolder + "/" + subsubfolder + "/image.png").toString().substring(6));
                        //System.out.println(tmpFile.exists()+ " " + tmpFile.isDirectory() + " " + tmpFile);
                        images.get(folder).get(subfolder).put(subsubfolder, ImageIO.read(getClass().getResource("Resources/" + folder  + "/" + subfolder + "/" + subsubfolder + "/image.png")));
                }
            }
        }
        
        TitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("TitleFont.ttf"));
        TextFont = Font.createFont(Font.TRUETYPE_FONT, new File("TextFont.ttf"));
    }
}
