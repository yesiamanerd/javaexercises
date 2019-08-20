package concurrency.deitel.exercises.producer_consumer.arrayblockingqueue;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    // place value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s %2d\t\t\t%d\t%n", " Producer Writes", value, buffer.size());
    }

    // return value from buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take();
        System.out.printf("%s %2d\t\t\t%d\t%n", " Consumer Reads ", readValue, buffer.size());

        return readValue;
    }
}
