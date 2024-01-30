package org.example;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nPhone Number: " + this.phoneNumber + "\nEmail: " + this.email;
    }
}
