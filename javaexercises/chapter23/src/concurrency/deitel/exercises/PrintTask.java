package concurrency.deitel.exercises;


// Creating concurrent tasks with the Runnable interface
//
// Executing Runnable Objects with an Executor
//
// Using class Executors to obtain an ExecutorService
//
// Implementing the Runnable interface

import java.security.SecureRandom;

public class PrintTask implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;

        // random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000);
    }

    // method run contains the code that the thread will execute
    @Override
    public void run() {
        try{
            System.out.printf("%s going to sleep for %d milliseconds %n", taskName, sleepTime);

            Thread.sleep(sleepTime); // put thread to sleep
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
            Thread.currentThread().interrupt();
        }

        // print task name
        System.out.printf("%s done sleeping%n", taskName);
    }
}
