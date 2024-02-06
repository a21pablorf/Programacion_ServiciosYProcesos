package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server.");

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);

            //Empezamos un hilo para poder recibir mensajes del servidor
            Thread userInputThread = new Thread(new ChatClientUserInput(socket, serverReader, serverWriter));
            userInputThread.start();

            //Escuchamos al servidor, que nos manda el mensaje de otro cliente
            String serverResponse;
            while ((serverResponse = serverReader.readLine()) != null) {
                System.out.println("Server: " + serverResponse);
            }

            // Close resources
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
