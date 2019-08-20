package concurrency.deitel.exercises.producer_consumer.nonthreadsafe;
// Consumer with a run method that loops, reading 10 values from buffer.

import java.security.SecureRandom;

public class Consumer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;  // shared object

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // read sharedLocation's value 10 times and sum the values
    @Override
    public void run() {
        int sum = 0;

        for(int i = 0; i <= 10; i++){
            try{
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
                System.out.printf("%-82s%2d%n", " ", sum);
            }
            catch (InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("%n%s %d%n%s%n",
                "Consumer read values totaling", sum, "Terminating Consumer");
    }
}
