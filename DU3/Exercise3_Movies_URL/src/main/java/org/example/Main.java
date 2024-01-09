package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        final String API_KEY = "4bfed728";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();


        try(InputStream is=new URL("http://www.omdbapi.com/?apikey=" + API_KEY + "&t="+ title).openStream()){
            String json = new String(is.readAllBytes());
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}