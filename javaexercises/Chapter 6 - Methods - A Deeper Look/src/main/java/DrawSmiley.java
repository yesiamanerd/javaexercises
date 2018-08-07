import javax.swing.*;
import java.awt.*;

/**
 * Created by geoffrey on 2/11/18.
 */
public class DrawSmiley extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // draw the face
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 200);

        // draw the eyes
        g.setColor(Color.BLACK);
        g.fillOval(55, 65, 30, 30);
        g.fillOval(135, 65, 30, 30);

        // draw the mouth
        g.fillOval(50, 110, 120, 60);

        // shape mouth into a smile
        g.setColor(Color.YELLOW);
        g.fillRect(50, 110, 120, 30);
        g.fillOval(50, 120, 120, 40);
    }
}
