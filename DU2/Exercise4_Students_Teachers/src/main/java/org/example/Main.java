package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Greeting gret=new Greeting();


        Thread[] threads=new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i]= new Thread(new Person("Student "+i,true,gret));
        }
        Thread t1=new Thread(new Person("Teacher RODOLFO",false,gret));
        t1.start();
        for(Thread thread:threads){
            thread.start();
        }
    }
}