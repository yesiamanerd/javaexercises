package concurrency.deitel.exercises.producer_consumer.advanced_circularbuffer;

import concurrency.deitel.exercises.producer_consumer.nonthreadsafe.Buffer;

public class CircularBuffer implements Buffer {
    private final int[] buffer = {-1, -1, -1}; // shared buffer

    private int occupiedCells = 0; // count number of buffers used
    private int writeIndex = 0; // index of next element to write to
    private int readIndex = 0; // index of next element to read

    // place value onto buffer
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        // wait until buffer has space available, then write value;
        // while no empty locations, place thread in blocked state
        while(occupiedCells == buffer.length){
            System.out.printf("Buffer is full.  Producer waits.");
            wait();
        }

        // set new buffer value
        buffer[writeIndex] = value;

        // update circular write index
        writeIndex = (writeIndex + 1) % buffer.length;

        ++occupiedCells;
        displayState("Producer writes " + value);
        notifyAll(); // notify all threads waiting to hear from buffer



    }

    // take value from buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        // wait until buffer has data, then read value;
        // while no data to read, place thread in waiting state
        while (occupiedCells == 0){
            System.out.printf("Buffer is empty. Consumer waits.");
            wait();
        }

        // read value from the buffer
        int readValue = buffer[readIndex];

        // update circular read index
        readIndex = (readIndex + 1) % buffer.length;

        --occupiedCells;
        displayState("Consumer reads: " + readValue);
        notifyAll();

        return readValue;
    }

    // display current operation and buffer state; f
    public synchronized void displayState(String operation)
    {
        // output operation and the number of occupied buffer cells
        System.out.printf("%s%s%d)%n%s", operation,
                " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");
        // output values in the buffer
        for(int value: buffer){
            System.out.printf("  %2d ", value);
        }

        System.out.printf("%n                 ");

        for(int i = 0; i < buffer.length; i++)
            System.out.print("---- ");

        System.out.printf("%n                 ");

        for(int i = 0; i < buffer.length; i++){
            if(i == writeIndex && i == readIndex)
                System.out.print(" WR  ");
            else if(i == writeIndex)
                System.out.print(" W   ");
            else if(i == readIndex)
                System.out.print("  R  ");
            else
                System.out.print("     ");

        }

        System.out.printf("%n%n");
    }
}
