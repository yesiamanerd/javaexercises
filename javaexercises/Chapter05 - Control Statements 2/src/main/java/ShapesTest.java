import javax.swing.*;

/**
 * Created by geoffrey on 2/11/18.
 */
public class ShapesTest {
    public static void main(String[] args){
//        String input = JOptionPane.showInputDialog(
//                "Enter 1 to draw rectangles\n" +
//                        "Enter 2 to draw ovals"
//        );
//
//        int choice = Integer.parseInt(input);

        int choice = 2;

        // create the panel with the user's input
        Shapes panel = new Shapes(choice);

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);

        application.setVisible(true);
    }
}
