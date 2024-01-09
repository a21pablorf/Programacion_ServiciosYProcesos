package org.example;

import java.util.Random;

public class RandomPauseThread implements Runnable{

    @Override
    public void run() {
        String threadName= Thread.currentThread().getName();
        System.out.println("Hello this thread is: "+threadName);

        for (int i = 0; i <5; i++) {
            Random r=new Random();
            int n= r.nextInt(10,501);
            System.out.println(n);
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread: "+Thread.currentThread().getName()+" says goodbye.");
    }
}
