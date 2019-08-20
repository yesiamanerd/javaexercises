package concurrency.deitel.exercises.simplearray.threadsafe;
// Adds integers to an array shared with other Runnables

import concurrency.deitel.exercises.simplearray.nonthreadsafe.SimpleArray;

public class ArrayWriter implements Runnable {

    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int startValue, SimpleArray sharedSimpleArray) {
        this.sharedSimpleArray = sharedSimpleArray;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        for(int i = startValue; i < startValue + 3; i++){
            sharedSimpleArray.add(i);
        }
    }
}
