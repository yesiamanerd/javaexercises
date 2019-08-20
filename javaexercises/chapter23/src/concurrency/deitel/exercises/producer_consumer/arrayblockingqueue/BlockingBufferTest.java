package concurrency.deitel.exercises.producer_consumer.arrayblockingqueue;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Consumer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest {
    public static void main(String[] args) throws InterruptedException {
        // create new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.printf(
                "%6s%25s%27s%17s%16s%n", "Action", "Buffer", "", "Sum of Produced", "Sum of Consumed");
        System.out.printf(
                "%-6s%25s%27s%17s%16s%n", "------", "------", "", "---------------", "---------------");

        // create Blocking Buffer to store ints
        Buffer sharedLocation = new BlockingBuffer();

        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }
}
