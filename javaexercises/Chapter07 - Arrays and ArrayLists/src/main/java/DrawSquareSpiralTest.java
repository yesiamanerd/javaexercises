import javax.swing.*;

/**
 * Created by geoffrey on 2/12/18.
 */
public class DrawSquareSpiralTest {
    public static void main(String[] args){
        DrawSquareSpiral panel = new DrawSquareSpiral();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(200, 200);
        application.setVisible(true);
    }
}
