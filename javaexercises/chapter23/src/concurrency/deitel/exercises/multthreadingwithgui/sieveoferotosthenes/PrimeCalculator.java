package concurrency.deitel.exercises.multthreadingwithgui.sieveoferotosthenes;
// Calculates the first n primes, displaying them as they are found.

import javax.swing.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class PrimeCalculator extends SwingWorker<Integer, Integer> {

    private static final SecureRandom generator = new SecureRandom();
    private final JTextArea intermediateJTextArea;  // displays found primes
    private final JButton getPrimesJButton;
    private final JButton cancelJButton;
    private final JLabel statusJLabel;              // displays status of calculation
    private final boolean[] primes;                 // boolean array for finding primes

    // constructor


    public PrimeCalculator(
            int max,
            JTextArea intermediateJTextArea,
            JLabel statusJLabel,
            JButton getPrimesJButton,
            JButton cancelJButton) {
        this.intermediateJTextArea = intermediateJTextArea;
        this.statusJLabel = statusJLabel;
        this.getPrimesJButton = getPrimesJButton;
        this.cancelJButton = cancelJButton;
        this.primes = new boolean[max];
        Arrays.fill(primes, true); // initialize all primes elements to true
    }

    // find all primes up to the max using the Sieve of Erotosthenes
    @Override
    protected Integer doInBackground(){
        int count = 0; // number of primes found

        // starting at the third value, cycle through the array and put
        // false as the value of any greater number that is a multiple
        for(int i = 2; i < primes.length; i++){
            if(isCancelled()){  // if calculation has been cancelled
                return count;
            }
            else {
                setProgress(100 * (i + 1)/primes.length);

                try{
                    Thread.sleep(generator.nextInt(5));
                }
                catch (InterruptedException ie){
                    statusJLabel.setText("Worker thread interrupted.");
                    return count;
                }

                if(primes[i]){ // if i is a prime
                    publish(i);  // make i available for display in the prime list
                    ++count;

                    for(int j = i + i; j < primes.length; j += i){
                        primes[j] = false; // set multiples of i as not a prime
                    }

                }
            }
        }

        return count;
    }


    // displays published values in the primes list
    protected void process(List<Integer> publishedVals){
        for(int i = 0; i < publishedVals.size(); i++){
            intermediateJTextArea.append(publishedVals.get(i) + "\n");
        }

    }

    // code to execute when doInBackground is complete
    protected void done(){
        getPrimesJButton.setEnabled(true);  // display Get Primes JButton

        cancelJButton.setEnabled(false);    // disable Cancel Button

        try{
            // retrieve and display doInBackground return value
            statusJLabel.setText("Found " + get() + " primes.");
        }
        catch (InterruptedException | ExecutionException | CancellationException e){
            statusJLabel.setText(e.getMessage());
        }
    }
}
