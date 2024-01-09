package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r=new Random();

        int numeroObjetivo=r.nextInt(0,101);

        HiddenNumber hd=new HiddenNumber(numeroObjetivo);
        Thread[] guesserThreads=new Thread[10];

        System.out.println("O numero a adiviñar e: "+numeroObjetivo);

        for (int i = 0; i < 10; i++) {
            guesserThreads[i]=new Thread(new MainThread(hd));
            guesserThreads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                guesserThreads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error en la ejecucion");
                throw new RuntimeException(e);
            }
        }

    }
}