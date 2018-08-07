import javax.swing.*;
import java.awt.*;

/**
 * Created by geoffrey on 2/12/18.
 */
public class DrawSquareSpiral extends JPanel {
    private static int increment = 10;
    private static int x, y;

    public DrawSquareSpiral(){
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        //super.paintComponent(g);

        g.setColor(Color.BLACK);
        x = getWidth()/2;
        y = getHeight()/2;

        for (int i = 0; i <= 10; i++){
            drawSpiral(g);
        }
    }

    private void drawSpiral(Graphics g) {
        drawDown(g, x, y);
        y += increment;
        drawLeft(g, x, y);
        x -= increment;
        increment += 10;
        drawUp(g, x, y);
        y -= increment;
        drawRight(g, x, y);
        x += increment;
        increment += 10;
    }

    private void drawRight(Graphics g, int x, int y) {
        g.drawLine(x, y, x + increment, y);
    }

    private void drawUp(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y - increment);
    }

    private void drawLeft(Graphics g, int x, int y) {
        g.drawLine(x, y, x - increment , y);

    }

    private void drawDown(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y + increment);

    }
}
