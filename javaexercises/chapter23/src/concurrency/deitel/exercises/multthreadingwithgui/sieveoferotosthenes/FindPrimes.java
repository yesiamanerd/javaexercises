package concurrency.deitel.exercises.multthreadingwithgui.sieveoferotosthenes;
// Using a SwingWorker to display prime numbers and update a JProgressBar
// while the prime numbers are being calculated.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FindPrimes extends JFrame {

    private final JTextField highestPrimeJTextField = new JTextField();
    private final JButton getPrimesJButton = new JButton("Get Primes");
    private final JTextArea displayPrimesJTextArea = new JTextArea();
    private final JButton cancelJButton = new JButton("Cancel");
    private final JProgressBar progressJProgressBar = new JProgressBar();
    private final JLabel statusJLabel = new JLabel();
    private PrimeCalculator calculator;

    public FindPrimes() {
        super("Finding Primes with SwingWorker");
        setLayout(new BorderLayout());

        // initialize panel to get a number from the user
        JPanel northJPanel = new JPanel();
        northJPanel.add(new JLabel("Find primes less than: "));
        highestPrimeJTextField.setColumns(5);
        northJPanel.add(highestPrimeJTextField);
        getPrimesJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        progressJProgressBar.setValue(0);   // reset JProgressBar
                        displayPrimesJTextArea.setText(""); // clear JTextArea
                        statusJLabel.setText("");           // clear JLabel

                        int number; // search for primes up to this number

                        try{
                            // get user input
                            number = Integer.parseInt(highestPrimeJTextField.getText());
                        }
                        catch (NumberFormatException nfe){
                            statusJLabel.setText("Enter an Integer: ");
                            return;
                        }

                        // construct a new PrimeCalculator object
                        calculator = new PrimeCalculator(
                                number,
                                displayPrimesJTextArea,
                                statusJLabel,
                                getPrimesJButton,
                                cancelJButton
                        );

                        // listen for progress bar property changes
                        calculator.addPropertyChangeListener(
                                new PropertyChangeListener() {
                                    @Override
                                    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                                        // if the changed property is progress,
                                        // update the progress bar
                                        if(propertyChangeEvent.getPropertyName().equals("progress")){
                                            int newValue = (Integer) propertyChangeEvent.getNewValue();
                                            progressJProgressBar.setValue(newValue);
                                        }

                                    }
                                }
                        );

                        // disable Get Primes button and enable Cancel button
                        getPrimesJButton.setEnabled(false);
                        cancelJButton.setEnabled(true);

                        calculator.execute();

                    }
                }
        );
        northJPanel.add(getPrimesJButton);

        // add a scrollable JList to display results of calculation
        displayPrimesJTextArea.setEditable(false);
        add(new JScrollPane(displayPrimesJTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        // initialize a panel to display cancelJButton
        //  progressJProgressBar, and statusJLabel
        JPanel southJPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        cancelJButton.setEnabled(false);
        cancelJButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        calculator.cancel(true);
                    }
                }
        );

        southJPanel.add(cancelJButton);
        progressJProgressBar.setStringPainted(true);
        southJPanel.add(progressJProgressBar);
        southJPanel.add(statusJLabel);

        add(northJPanel, BorderLayout.NORTH);
        add(southJPanel, BorderLayout.SOUTH);
        setSize(450, 350);
        setVisible(true);

    }

    // main method begins program execution
    public static void main(String[] args) {
        FindPrimes application = new FindPrimes();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
