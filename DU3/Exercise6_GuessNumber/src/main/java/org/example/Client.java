package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 47500);

            try (
                    DataInputStream reader = new DataInputStream(socket.getInputStream());
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream())
            ) {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                //Primer mensaje del servidor
                String serverResponse = reader.readUTF();
                System.out.println("Server: " + serverResponse);

                String userInput;
                while ((userInput = consoleReader.readLine()) != null) {
                    writer.writeUTF(userInput);

                    serverResponse = reader.readUTF();
                    System.out.println("Server: " + serverResponse);

                    if (serverResponse.equals(Protocol.BYE)) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente "+e.getMessage());
        }
    }
}

