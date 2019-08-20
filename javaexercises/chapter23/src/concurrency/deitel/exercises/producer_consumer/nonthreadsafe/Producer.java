package concurrency.deitel.exercises.producer_consumer.nonthreadsafe;
// Producer with a run method that inserts the values 1 to 10 in buffer.

import java.security.SecureRandom;

public class Producer implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation; // shared object

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // store values from 1 to 10 in sharedLocation
    @Override
    public void run() {
        int sum = 0;

        for(int i = 0; i <= 10; i++){
            try{
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.blockingPut(i);
                sum += i;
                System.out.printf("%-66s%2d%n", " ", sum);

            }
            catch (InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf(
                "Producer done producing%nTerminating Producer%n");
    }
}
