package org.example;

//this class controls the flow of the program. It creates the threads and starts them. It also creates the shared object.
public class TakeANumber {
    public static void main(String[] args) {
        //create the shared object
        Bakery bakery = new Bakery();

        //create the threads
        Thread clerk = new Thread(new Clerk());
        Thread customer1 = new Thread(new Customer(1));
        Thread customer2 = new Thread(new Customer(2));
        Thread customer3 = new Thread(new Customer(3));
        Thread customer4 = new Thread(new Customer(4));
        Thread customer5 = new Thread(new Customer(5));

        //start the threads
        clerk.start();
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
    }

}
