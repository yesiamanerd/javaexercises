package concurrency.deitel.exercises.producer_consumer.nonthreadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        // create new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create UnsynchronizedBuffer to store ints
        Buffer sharedLocation = new UnsynchronizedBuffer();

//        System.out.println(
//                "Action\t\t\t\tValue\tSum of Produced\tSum of Consumed");
//        System.out.printf(
//                "------\t\t\t\t-----\t---------------\t---------------%n%n");
        System.out.printf(
                "%6s%19s%33s%17s%16s%n", "Action", "Value", "", "Sum of Produced", "Sum of Consumed");
        System.out.printf(
                "%-6s%19s%33s%17s%16s%n", "------", "------", "", "---------------", "---------------");

        // execute the Producer and Consumer, giving each
        // access to the sharedLocation
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
