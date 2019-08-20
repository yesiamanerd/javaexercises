package concurrency.deitel.exercises.producer_consumer.advanced_circularbuffer;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Consumer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircularBufferTest {
    public static void main(String[] args) throws InterruptedException{
        // create a new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create CircularBuffer to store ints
        CircularBuffer sharedLocation = new CircularBuffer();

        System.out.println(
                "Action\t\t\t\t\t\t\t\t\t\t\t\t\t\tSum of Produced\tSum of Consumed");
        System.out.printf(
                "------\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------\t---------------%n%n");

        // display the initial state of the CircularBuffer
        sharedLocation.displayState("Initial State");

        // execute the Producer and Consumer tasks
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
