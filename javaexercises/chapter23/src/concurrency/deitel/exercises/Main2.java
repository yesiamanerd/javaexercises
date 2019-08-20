package concurrency.deitel.exercises;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static final int MAX_PASSWORD = 9_999;

    public static void main(String[] args) throws InterruptedException {
        SecureRandom generator = new SecureRandom();

        Vault vault = new Vault(generator.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread : threads)
            thread.start();
    }

    private static class Vault {
        private int password;

        public Vault(int password){
            this.password = password;
        }

        public boolean isCorrectPassword(int guess){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread{
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting thread: " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess = 0; guess < MAX_PASSWORD; guess++){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(this.getName() + " guess the password " + guess);
                    System.exit(0);
                }
            }
            super.run();
        }
    }

    private static class DescendingHackerThread extends HackerThread {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess = MAX_PASSWORD; guess >= 0; guess--){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(this.getName() + " guess the password " + guess);
                    System.exit(0);
                }
            }
            super.run();
        }


    }

    private static class PoliceThread extends Thread {

        public PoliceThread() {
            this.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            for(int i = 10; i > 0; i--){
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("PoliceThread countdown: " + i);
            }

            System.out.println("Game over for you hackers!!");
            System.exit(0);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting thread: " + this.getName());
            super.start();
        }
    }

//    private static class NewThread extends Thread {
//        @Override
//        public void run() {
//            System.out.println("Hello from: " + this.getName());
//        }
//    }

}
