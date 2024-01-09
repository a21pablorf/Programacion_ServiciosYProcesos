package org.example;

import java.util.Random;

public class MainThread implements Runnable{

    HiddenNumber hd;

    public MainThread(HiddenNumber hd) {
        this.hd = hd;
    }

    @Override
    public void run() {
        Random r=new Random();

        int returned=0;

        while (!hd.isGameIsOver()){
            int x=r.nextInt(0,101);
            returned=hd.numberGuess(x);
            if(returned==1){
                System.out.println("O Thread con nome: "+Thread.currentThread().getName()+" adiviñou o numero: "+x);
            }else{
                System.out.println("Numero non acertado");
            }
        }



    }
}