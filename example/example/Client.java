package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int opcion = 2;
        Scanner sc = new Scanner(System.in);
        while (opcion != 0) {
            System.out.println("1. Enviar mensaje");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            if (args.length != 1) {
                System.err.println("Pass the server IP as the sole command line argument");
                return;
            }
            if (opcion == 1) {
                System.out.print("Enter a number: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String message = reader.readLine();

                var socket = new Socket(args[0], 57001);

                try (
                        var out = new PrintWriter(socket.getOutputStream(), true);
                        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    out.println(message);
                    String encryptedMessage = in.readLine();
                    System.out.println("Number received from server: " + encryptedMessage);
                }
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
                System.exit(0);
            }
        }
    }
}
