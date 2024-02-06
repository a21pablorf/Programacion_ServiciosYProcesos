package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientUserInput implements Runnable {
    private final Socket socket;
    private final BufferedReader serverReader;
    private final PrintWriter serverWriter;
    private final BufferedReader consoleReader;

    public ChatClientUserInput(Socket socket, BufferedReader serverReader, PrintWriter serverWriter) {
        this.socket = socket;
        this.serverReader = serverReader;
        this.serverWriter = serverWriter;
        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void run() {
        try {
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                serverWriter.println(userInput); // Send user input to server

                // Check if user wants to quit
                if (userInput.equalsIgnoreCase("QUIT")) {
                    break;
                }
            }
            socket.close();
            consoleReader.close();
        } catch (IOException e) {
            System.err.println("Error en el envio del mensaje"+e.getMessage());
        }
    }
}
