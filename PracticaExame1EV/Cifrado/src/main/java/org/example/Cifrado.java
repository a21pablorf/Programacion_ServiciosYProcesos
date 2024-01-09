package org.example;

import java.util.Scanner;

public class Cifrado {
    //create a function for each uppercase or lowercase letter must be shifted three positions to the right, according to the ASCII table: letter 'a' should become letter 'd', letter 'y' must become the character '|' and so on. Second, . After being reversed, all characters from the half on (truncated) must be moved one position to the left in ASCII. In this case, 'b' becomes 'a' and 'a' becomes '`'.

    public String cifrarFirstStep(String texto){

        String txtCifrado = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            //if the letter is a letter from the alphabet, it will be shifted three positions to the right
            if ((letra >= 'a' && letra <= 'z')||(letra >= 'A' && letra <= 'Z')){
                letra = (char) (letra + 3);
            }
            else if (letra == ' ') {
                letra = (char) (letra + 0);
            } else {
                letra = (char) (letra + 0);
            }
            txtCifrado += letra;
        }
        return txtCifrado;
    }

    //Create a function to reverse the text
    public String cifrarSecondStep(String texto){
        String txtCifrado = "";
        for (int i = texto.length()-1; i >= 0; i--) {
            char letra = texto.charAt(i);
            txtCifrado += letra;
        }
        return txtCifrado;
    }

    //Create a function to all characters from the half on (truncated) must be moved one position to the left in ASCII
    public String cifrarThirdStep(String texto){
        int start = texto.length()/2;
        StringBuilder txtCifrado = new StringBuilder();
        for (int i = start; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == ' ') {
                letra = (char) (letra);
            } else {
                letra = (char) (letra - 1);
            }
            txtCifrado.append(letra);
        }
        //returns the original first half and the new second half concatenated
        return texto.substring(0, start) + txtCifrado;
    }

}
