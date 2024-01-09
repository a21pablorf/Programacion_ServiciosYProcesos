package org.example;

public class Clerk implements Runnable {
    //A clerk in a bakery serves customers in the order they took their tickets. Customers take tickets in a random order.
    //The clerk takes a random time of no more than 1000ms to serve a customer.
    Bakery bakery = new Bakery();
    @Override
    public void run() {
        while (true) {
            bakery.serveNumber();
            bakery.nextCustomer();
        }
    }
}
