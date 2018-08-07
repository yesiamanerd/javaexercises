import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

/**
 * Created by geoffrey on 2/11/18.
 */
public class RandomShapes extends JPanel {
    private static int red, green, blue;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int height = super.getHeight();
        int width = super.getWidth();
        int halfHeight = super.getHeight()/2;
        int halfWidth = super.getWidth()/2;
        SecureRandom secureRandom = new SecureRandom();

        for(int i = 0; i < 10; i++) {
            int xCord = secureRandom.nextInt(width) - 50;
            int yCord = secureRandom.nextInt(height) - 50;
            int shapeWidth = secureRandom.nextInt(halfWidth);
            int shapeHeight = secureRandom.nextInt(halfHeight);
            int shape = secureRandom.nextInt(2);

            getColors(secureRandom);
            Color color1 = new Color(red, green, blue);

            // draw the face
            g.setColor(color1);
            if (shape == 0)
                g.fillOval(xCord, yCord, shapeWidth, shapeHeight);
            else
                g.fillRect(xCord, yCord, shapeWidth, shapeHeight);
        }
    }

    private void getColors(SecureRandom secureRandom) {
        red = secureRandom.nextInt(256);
        green = secureRandom.nextInt(256);
        blue = secureRandom.nextInt(256);
    }


}
