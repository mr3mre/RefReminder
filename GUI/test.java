package GUI;

import APIs.src.java.net.http.SpoonacularAPI;
import Logic.Recipe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class test {

    public static void main( String[] args ) throws IOException, InterruptedException {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        SpoonacularAPI api = new SpoonacularAPI();

        Recipe recipe = api.getRandomRecipe();
        JLabel jLabelName = new JLabel();
        jLabelName.setText( recipe.getRecipeName() );
        URL url = new URL( recipe.getImageURL() );
        BufferedImage image = ImageIO.read( url );
        JLabel picLabel = new JLabel( new ImageIcon(image));
        panel.add( picLabel );
        frame.add( panel );
        frame.setVisible(true);
    }
}
