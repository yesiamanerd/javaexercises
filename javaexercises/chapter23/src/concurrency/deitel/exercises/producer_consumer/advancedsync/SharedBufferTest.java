package concurrency.deitel.exercises.producer_consumer.advancedsync;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Consumer;
import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.println(
                "Action\t\t\t\t\t\t\t\tBuffer\t\tOccupied\tSum of Produced\tSum of Consumed");
        System.out.printf(
                "------\t\t\t\t\t\t\t\t------\t\t--------\t---------------\t---------------%n%n");

        // execute the producer and consumer tasks
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
