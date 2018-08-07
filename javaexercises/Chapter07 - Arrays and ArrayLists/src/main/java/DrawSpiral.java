import javax.swing.*;
import java.awt.*;

/**
 * Created by geoffrey on 2/12/18.
 */
public class DrawSpiral extends JPanel {
    private static int increment = 10;
    private static int x, y;

    public DrawSpiral(){
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int increment = 10;

        x = getWidth() / 2;
        y = getHeight() / 2;

        while (increment < 250){
            g.drawArc(x, y, increment, increment , 0, 180);
            x -= 10;
            y -= 5;
            increment += 10;
            g.drawArc(x, y, increment, increment, 180, 180);
            y -= 5;
            increment += 10;
        }
    }
}
