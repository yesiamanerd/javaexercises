package concurrency.deitel.exercises.producer_consumer.advanced_lockcondition;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer {

    // Lock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    // conditions to control reading and writing
    private final Condition canRead = accessLock.newCondition();
    private final Condition canWrite = accessLock.newCondition();

    private int buffer = -1;          // shared by both Producer and Consumer threads
    private boolean occupied = false; // whether buffer is occupied

    // place int value into buffer
    @Override
    public void blockingPut(int value) throws InterruptedException {
        accessLock.lock(); // lock this object

        // output buffer information and thread information, then wait
        try {
            // while buffer is not empty, place thread in waiting state
            while(occupied){
                System.out.println("Producer tries to write.");
                displayState("Buffer Full. Producer waits.");
                canWrite.await(); // wait until buffer is empty
            }

            buffer = value; // set new buffer value

            // indicate that producer cannot store another value
            // until consumer retrieves current buffer value
            occupied = true;

            displayState("Producer writes " + buffer);

            // signal any threads waiting to read from buffer
            canRead.signalAll();
        }
//        catch (InterruptedException ie){
//
//        }
        finally {
            accessLock.unlock(); // unlock this object
        }
    }


    // retrieve value from buffer
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = 0; // initialize value read from buffer
        accessLock.lock(); // lock this object

        // output thread information and buffer information, then wait
        try{
            while (!occupied){
                System.out.println("Consumer tries to read.");
                displayState("Buffer empty. Consumer waits.");
                canRead.await();
            }

            // indicate that Producer can store another value
            // because Consumer just retrieved buffer value
            occupied = false;

            readValue = buffer; // retrieve value from buffer
            displayState("Consumer reads " + readValue);

            // signal any threads waiting for buffer to be empty
            canWrite.signalAll();
        }
        finally {
            accessLock.unlock();
        }

        return readValue;
    }

    // display current operation and buffer state
    private void displayState(String operation) {
        try{
            accessLock.lock();
            System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
        }
        finally {
            accessLock.unlock();
        }

    }
}
