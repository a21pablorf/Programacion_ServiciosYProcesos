package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(encrypt("proba"));
    }
    public static String encrypt(String message){
        message=message.toLowerCase();
        Character[][] matrix={
                {'a','b','c','d','e','f'},
                {'g','h','i','j','k','l'},
                {'m','n','o','p','q','r'},
                {'s','t','u','v','w','x'},
                {'y','z','0','1','2','3'},
                {'4','5','6','7','8','9'}
        };

        String encryptedMessage="";

        for(int i=0;i<message.length();i++){
            for(int j=0;j<6;j++){
                for(int k=0;k<6;k++){
                    if(message.charAt(i)==matrix[j][k]){
                        encryptedMessage+=j+1;
                        encryptedMessage+=k+1;
                        encryptedMessage+=" ";
                    }
                }
            }
        }
        return encryptedMessage;
    }
}