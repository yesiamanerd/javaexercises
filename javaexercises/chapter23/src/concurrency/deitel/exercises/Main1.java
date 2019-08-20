package concurrency.deitel.exercises;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in the thread: " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional Exception");
            }
        });

//        thread.setName("New Worker Thread");
        thread.setName("Misbehaving thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println("A critical error happened.");
            }
                                           }
        );

        System.out.println("We are in the thread: " + Thread.currentThread().getName() + " before starting a new thread.");
        thread.start();
        System.out.println("We are in the thread: " + Thread.currentThread().getName() + " after starting a new thread.");

        Thread.sleep(10_000L);
    }
}
