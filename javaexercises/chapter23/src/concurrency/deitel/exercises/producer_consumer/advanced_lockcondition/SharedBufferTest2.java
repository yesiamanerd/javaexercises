package concurrency.deitel.exercises.producer_consumer.advanced_lockcondition;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Consumer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest2 {
    public static void main(String[] args) throws InterruptedException{
        // create new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create synchronized buffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.println(
                "Action\t\t\t\t\t\t\t\tBuffer\t\tOccupied\tProducer Sum\tConsumer Sum");
        System.out.printf(
                "------\t\t\t\t\t\t\t\t------\t\t--------\t------------\t------------%n%n");

        // execute the producer and consumer tasks
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
