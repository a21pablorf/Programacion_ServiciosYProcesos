package org.example;

public class Greeting {
    private boolean teacherArrived;

    public Greeting() {
        this.teacherArrived=false;
    }

    public synchronized void teacherGreets(String name){
        System.out.println(name+ " greets Students");
        this.teacherArrived=true;
        notifyAll();
    }

    public synchronized void studentGreets(String name){
        try{
            if (!this.teacherArrived){
                wait();
                System.out.println(name+" greets teacher.");
            }
            else{
                System.out.println(name+" greets teacher and apologizes for being late.");
            }

        } catch (InterruptedException e) {
            System.err.println("Problema en el saludo del estudiante");
        }
    }
}
