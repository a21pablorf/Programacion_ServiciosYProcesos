package org.example;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random r=new Random();
        Smoker[] smokers=new Smoker[3];
        for (int i = 0; i < smokers.length; i++) {
            smokers[i]=new Smoker("Fumador "+i,i);
        }
        Tobacconist tobacconist=new Tobacconist(r.nextInt(3),r.nextInt(5));

        TobaccoShop shop=new TobaccoShop(smokers,tobacconist);

        Thread t1=new Thread(shop);
        t1.start();
    }
}