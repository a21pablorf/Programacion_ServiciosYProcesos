package org.example;

public class Bakery {
    private int lastNumber = 0;
    private int lastServed = 0;
    private int lastTaken = 0;
    private boolean isServed = false;
    private boolean hasNumber = false;

//    public synchronized int takeNumber() {
//        lastNumber++;
//        lastTaken = lastNumber;
//        hasNumber = true;
//        System.out.println("Customer " + lastNumber + "enters the bakery and takes a number.");
//        return lastNumber;
//    }

    public synchronized void takeNumber(int idNumber) {
        try {
            Thread.sleep((long) (Math.random() * 20000 + 20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + idNumber + " enters the bakery and takes a number.");
        hasNumber = true;
        notifyAll();
    }

    public synchronized void serveNumber() {
        while (!hasNumber) {
            try {
                System.out.println("Clerk is waiting for a customer to arrive.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lastServed = lastTaken;
        System.out.println("Customer " + lastServed + " is served.");
        isServed = true;
        notifyAll();
    }

    public synchronized void nextCustomer() {
        while (!isServed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isServed = false;
        notifyAll();
    }
}
