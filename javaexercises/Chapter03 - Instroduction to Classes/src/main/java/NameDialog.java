import javax.swing.*;

/**
 * Created by geoffrey on 1/28/18.
 */
public class NameDialog {
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("What is your name? ");

        String message = String.format("Welcome, %s, to Java Programming!", name);

        JOptionPane.showMessageDialog(null, message);
    }
}
