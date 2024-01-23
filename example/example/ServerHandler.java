package org.example;

import java.io.*;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private final Socket connection;
    public ServerHandler(Socket connection) {
        this.connection = connection;
    }
    @Override
    public void run() {
        System.out.println("Client connected");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            int numberSquare = Integer.parseInt(reader.readLine());
            System.out.println("Number received from client: " + numberSquare);
            writer.write(numberSquare * numberSquare + "\n");
            writer.newLine();
            writer.flush();

            System.out.println("Closing connection");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
