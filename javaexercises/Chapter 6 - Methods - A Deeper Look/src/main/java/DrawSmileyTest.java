import javax.swing.*;

/**
 * Created by geoffrey on 2/11/18.
 */
public class DrawSmileyTest {
    public static void main(String[] args){
        DrawSmiley panel = new DrawSmiley();
        DrawBullseye bullseye = new DrawBullseye();
        RandomShapes shapes = new RandomShapes();


//        JFrame application = new JFrame();
        JFrame application2 = new JFrame();

        // draw smiley face
//        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        application.add(panel);
//        application.setSize(220, 220);
//        application.setVisible(true);

        // draw bullseye
        application2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application2.add(shapes);
        application2.setSize(220, 220);
        application2.setVisible(true);
    }
}
