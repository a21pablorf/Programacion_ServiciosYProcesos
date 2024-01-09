package org.example;


public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RandomPauseThread(), "Thread 1");
        Thread thread2 = new Thread(new RandomPauseThread(), "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread has finished.");
    }
}