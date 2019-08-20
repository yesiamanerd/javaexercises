package concurrency.deitel.exercises;

import java.math.BigInteger;

public class MainInterrupt1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();

        Thread longRunningThread = new Thread(new LongComputationTask(new BigInteger("2000000"), new BigInteger("10000000")));
        longRunningThread.setDaemon(true);
        longRunningThread.start();
        longRunningThread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger num, BigInteger pow){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE)){
//                if(Thread.currentThread().isInterrupted()){
//                    System.out.println("Prematurely interrupted computation.");
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(num);
            }

            return result;
        }
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500_000);
            } catch (InterruptedException e) {
                System.out.println("Exiting simple blocking thread.");
            }
        }
    }
}
