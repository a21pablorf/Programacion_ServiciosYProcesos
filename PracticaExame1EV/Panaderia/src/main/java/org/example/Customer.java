package org.example;

public class Customer implements Runnable{
    //Each client waits a random time between 20000 and 40000 milliseconds to take a number after entering the bakery.

    //A clerk in a bakery serves customers in the order they took their tickets. Customers take tickets in a random order.
    //The clerk takes a random time of no more than 1000ms to serve a customer.
    //Each client waits a random time between 20000 and 40000 milliseconds to take a number after entering the bakery.

        private int idNumber;

    private boolean isServed = false;

    private boolean hasNumber = false;

    public boolean isServed() {
        return isServed;
    }

    public void setServed(boolean served) {
        isServed = served;
    }

    public Customer(int idNumber) {
        this.idNumber = idNumber;
    }
    Bakery bakery = new Bakery();

    @Override
    public void run() {
//        try {
//            Thread.sleep((long) (Math.random() * 20000 + 20000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Customer " + idNumber + " enters the bakery and takes a number.");
        if(!hasNumber) {
            bakery.takeNumber(idNumber);
        }
//        hasNumber = true;
//        while (!isServed) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Customer " + idNumber + " is served.");
    }
}
