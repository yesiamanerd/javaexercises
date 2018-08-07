import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

/**
 * Created by geoffrey on 2/11/18.
 */
public class DrawBullseye extends JPanel {
    private static int red, green, blue;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        SecureRandom secureRandom = new SecureRandom();

        getColors(secureRandom);
        Color color1 = new Color(red, green, blue);
        getColors(secureRandom);
        Color color2 = new Color(red, green, blue);

        // draw the face
        g.setColor(color1);
        g.fillOval(10, 10, 200, 200);
        g.setColor(color2);
        g.fillOval(30, 30, 160, 160);
        g.setColor(color1);
        g.fillOval(50, 50, 120, 120);
        g.setColor(color2);
        g.fillOval(70, 70, 80, 80);
        g.setColor(color1);
        g.fillOval(90, 90, 40, 40);

    }

    private void getColors(SecureRandom secureRandom) {
        red = secureRandom.nextInt(256);
        green = secureRandom.nextInt(256);
        blue = secureRandom.nextInt(256);
    }


}
