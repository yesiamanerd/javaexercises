import javax.swing.*;

/**
 * Created by geoffrey on 2/12/18.
 */
public class DrawRainbowTest {
    public static void main(String[] args){
        DrawRainbow panel = new DrawRainbow();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(400, 250);
        application.setVisible(true);
    }
}
