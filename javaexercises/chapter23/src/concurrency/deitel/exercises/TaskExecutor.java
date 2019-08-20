package concurrency.deitel.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        // create and name each runnable
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Staring Executor...");

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // start the three print tasks
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        // shut down ExecutorService -- it decides when to shut down threads
        executorService.shutdown();

        System.out.println("Tasks started, main ends%n%n");
    }
}
