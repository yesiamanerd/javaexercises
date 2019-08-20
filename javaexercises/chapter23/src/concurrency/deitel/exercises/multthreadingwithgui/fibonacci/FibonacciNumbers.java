package concurrency.deitel.exercises.multthreadingwithgui.fibonacci;
// Using SwingWorker to perform a long calculation with
// results displayed in a GUI.


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciNumbers extends JFrame {

    // components for calculating the fibonacci of a user-entered number
    private final JPanel workerJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    private final JTextField numberJTextField = new JTextField();
    private final JButton goJButton = new JButton("Go");
    private final JLabel fibonacciJLabel = new JLabel();

    // components and variables for getting the next fibonacci number
    private final JPanel eventThreadJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    private long n1 = 0;    // first fibonacci number
    private long n2 = 1;    // second fibonacci number
    private int count = 1;  // current fibonacci number to display
    private final JLabel nJLabel = new JLabel("Fibonacci of 1: ");
    private final JLabel nFibonacciJLabel = new JLabel(String.valueOf(n2));
    private final JButton nextNumberJButton = new JButton("Next Number");

    // constructor
    public FibonacciNumbers() {
        super("Fibonacci Numbers");
        setLayout(new GridLayout(2, 1, 10, 10));

        // add GUI components to the SwingWorker panel
        workerJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "With Swingworker"));
        workerJPanel.add(new JLabel("Get Fibonacci of: "));
        workerJPanel.add(numberJTextField);
        goJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int n;

                        try{
                            // retrieve user's input as an integer
                            n = Integer.parseInt(numberJTextField.getText());
                        }
                        catch (NumberFormatException nfe){
                            // display an error message is user did not enter an integer
                            fibonacciJLabel.setText("Enter an Integer.");
                            return;
                        }

                        // indicate that the calculation has begun
                        fibonacciJLabel.setText("Calculating...");

                        // create a task to perform calculation in the background
                        BackgroundCalculator task = new BackgroundCalculator(n, fibonacciJLabel);
                        task.execute(); // execute task

                    }
                } // end anonymous inner task
        ); // end call to addActionListener

        workerJPanel.add(goJButton);
        workerJPanel.add(fibonacciJLabel);

        // add GUI components to the event-dispatching thread panel
        eventThreadJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Without Swingworker"));

        eventThreadJPanel.add(nJLabel);
        eventThreadJPanel.add(nFibonacciJLabel);
        nextNumberJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        // calculate the fibonacci number after n2
                        long temp = n1 + n2;
                        n1 = n2;
                        n2 = temp;
                        ++count;

                        // display the next fibonacci number
                        nJLabel.setText("Fibonacci of " + count + ": ");
                        nFibonacciJLabel.setText(String.valueOf(n2));
                    }
                } // end anonymous inner class
        ); // end call to ActionListener
        eventThreadJPanel.add(nextNumberJButton);

        add(workerJPanel);
        add(eventThreadJPanel);
        setSize(275, 200);
        setVisible(true);

    }


    // add GUI components to the event-dispatching thread panel

    // main method begins program execution
    public static void main(String[] args) {
        FibonacciNumbers application = new FibonacciNumbers();

        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
