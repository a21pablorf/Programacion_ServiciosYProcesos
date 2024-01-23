package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //DATAINPUTSTREAM e DATAOUTPUTSTREAM para la comunicacion
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(47500);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
