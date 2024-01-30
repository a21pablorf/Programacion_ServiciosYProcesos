package org.example;

import java.util.ArrayList;

public class PhoneBook {
    //Create an array list of contacts
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    //Create a method to add a contact to the array list
    public void addContact(Contact contact){
        contacts.add(contact);
    }

    //Create a method to print all contacts in the array list. It must return an String with all the contacts
    public String printContacts(){
        StringBuilder allContacts = new StringBuilder();
        for(Contact contact : contacts){
            allContacts.append(contact.toString()).append("\n");
        }
        return allContacts.toString();
    }

    //Create a method to search for a name in the array list
    public String searchContact(String name){
        StringBuilder contact = new StringBuilder();
        for(Contact contact1 : contacts){
            if(contact1.getName().equals(name)){
                contact.append(contact1.toString()).append("\n");
            }
        }
        return contact.toString();
    }

}
