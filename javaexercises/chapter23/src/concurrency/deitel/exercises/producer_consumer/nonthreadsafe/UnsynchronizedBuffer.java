package concurrency.deitel.exercises.producer_consumer.nonthreadsafe;
// UnsynchronizedBuffer maintains the shared integer that is accessed by
// a producer thread and a consumer thread.

public class UnsynchronizedBuffer implements Buffer {
    private int buffer = -1; // shared by producer and consumer threads

    @Override
    public void blockingPut(int value) throws InterruptedException {
        System.out.printf("Producer writes: \t%2d%n", value);
        buffer = value;
    }

    @Override
    public int blockingGet() throws InterruptedException {
        System.out.printf("Consumer reads: \t%2d%n", buffer);
        return buffer;
    }
}
