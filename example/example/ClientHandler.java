package org.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    @Override
    public void run() {
        try(Socket socket = new Socket("localhost", 57001)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");

            writer.write(sc.nextInt() + "\n");
            writer.newLine();
            writer.flush();

            System.out.println("El cliente ha enviado el numero");
            String encryptedMessage = reader.readLine();
            System.out.println("El cliente ha recibido: " + encryptedMessage);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
