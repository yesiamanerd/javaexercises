import javax.swing.*;

/**
 * Created by geoffrey on 2/12/18.
 */
public class DrawSpiralTest{
    public static void main(String[] args){
        DrawSpiral panel = new DrawSpiral();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(200, 200);
        application.setVisible(true);
    }
}
