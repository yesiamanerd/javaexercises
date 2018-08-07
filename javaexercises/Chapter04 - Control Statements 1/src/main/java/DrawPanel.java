import javax.swing.*;
import java.awt.*;

/**
 * Created by geoffrey on 1/29/18.
 */
public class DrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int maxWidth = width;
        int maxHeight = height;
        int widthIncrement = width/15;
        int heightIncrement = height/15;
        width = 0;
        width += widthIncrement;
//        height -= heightIncrement;

//        g.drawLine(0,0, width, height);
//        g.drawLine(0, width, height, 0);
        while(width > 0 && height > 0){
//            g.drawLine(0,0, width, height);
//            g.drawLine(width, height, maxWidth, maxHeight);
//            g.drawLine(0, maxHeight, width, width);
//            g.drawLine(maxWidth, 0, width, width);
            g.drawLine(0, (maxHeight - width), height, maxHeight);
            g.drawLine((maxHeight - width), 0, maxHeight, height);
            g.drawLine(width, maxHeight, maxHeight, height);
            g.drawLine(0, height, width, 0);

            width += widthIncrement;
            height -= heightIncrement;
        }
    }
}
