package concurrency.deitel.exercises.simplearray.nonthreadsafe;

// Class that manages an integer array to be shared by multiple threads.
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray { // CAUTION: Not thread safe

    private static final SecureRandom generator = new SecureRandom();
    private final int[] array;
    private int writeIndex = 0;

    // construct a simple array of a given size
    public SimpleArray(int size){
        array = new int[size];
    }

    // add a value to the shared array
    public void add(int value){
        int position = writeIndex; // store the write index

        try{
            // put thread to sleep for 0 - 499 milliseconds
            Thread.sleep(generator.nextInt(500));
        }
        catch (InterruptedException ie){
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }

        // put value in the appropriate element
        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.%n",
                Thread.currentThread().getName(), value, position);

        ++writeIndex;  // increment index
        System.out.printf("Next write index: %d%n", writeIndex);
    }

    public String toString(){
        return Arrays.toString(array);
    }
}
