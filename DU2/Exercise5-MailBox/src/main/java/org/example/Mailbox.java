package org.example;

public class Mailbox {
    private String message;
    private boolean empty=true;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isEmpty() {
        return empty;
    }
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    public synchronized void deposit(String m){
        try{
            while(!isEmpty()){
                wait();
            }
            setMessage(m);
            empty=false;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized String pickUp(){
        try{
            while(isEmpty()){
                wait();
            }
            empty=true;
            notifyAll();
            return getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}