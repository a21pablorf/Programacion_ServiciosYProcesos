package org.example;

public class Collector implements Runnable{

    private Mailbox message;

    public Collector(Mailbox message) {
        this.message = message;
    }

    @Override
    public void run() {

    }
}
