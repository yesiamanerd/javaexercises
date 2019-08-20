package concurrency.deitel.exercises.multthreadingwithgui.fibonacci;
// SwingWorker subclass for calculating Fibonacci numbers
// in a background thread.

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class BackgroundCalculator extends SwingWorker<Long, Object> {

    private final int n;                // fibonacci number to calculate
    private final JLabel resultJLabel;  // JLabel to display the result

    public BackgroundCalculator(int n, JLabel resultJLabel) {
        this.n = n;
        this.resultJLabel = resultJLabel;
    }

    // long-running code to be run in a worker thread
    @Override
    protected Long doInBackground() throws Exception {
        return fibonacci(n);
    }

    // code to run on the event dispatch thread when doInBackground returns
    protected void done(){
        try{
            // get the result of doInBackground and display it
            resultJLabel.setText(get().toString());
        }
        catch (InterruptedException ie){
            resultJLabel.setText("Interrupted while waiting for results.");
        }
        catch (ExecutionException ee){
            resultJLabel.setText("Error encountered while performing calculations.");
        }
    }


    // recursive method fibonacci; calculates nth Fibonacci number
    public long fibonacci(long number) {
        if(number == 0 || number == 1){
            return number;
        }
        else {
            return (fibonacci(number - 1) + fibonacci(number - 2));
        }
    }
}
