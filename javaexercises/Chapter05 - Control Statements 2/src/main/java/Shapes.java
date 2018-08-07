import javax.swing.*;
import java.awt.*;

/**
 * Created by geoffrey on 2/11/18.
 */
public class Shapes extends JPanel {
    private int choice;

    // constructor set the user's choice
    public Shapes(int choice){
        this.choice = choice;
    }

    // draws a cascade of shapes starting from the top left corner
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int centerX = super.getWidth() / 2;
        int centerY = super.getHeight() / 2;

        for(int i = 0; i < 12; i++){
            int radius = (50 + i * 20)/2;

            //pick the shape based on the user's choice
            switch (choice){

                // draw rectangle
                case 1:
                    g.drawRect(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
                // draw oval
                case 2:
//                    g.drawOval(10 + i * 10, 10 + i * 10,
//                            50 + i * 10, 50 + i * 10);
                    g.drawOval((centerX - radius), (centerY - radius),
                            radius * 2, radius * 2);
                    break;
            }
        }
    }
}
