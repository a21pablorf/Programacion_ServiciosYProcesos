package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File file= new File("ejemplo.txt");
        List<String> lista = null;
        try {
          lista = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Cifrado cifrado = new Cifrado();

        for (String linea : lista) {
            String cifrado1 = cifrado.cifrarFirstStep(linea);
            String cifrado2 = cifrado.cifrarSecondStep(cifrado1);
            String cifrado3 = cifrado.cifrarThirdStep(cifrado2);
            System.out.println(cifrado3);
        }
    }
}