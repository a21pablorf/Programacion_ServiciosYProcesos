package org.example;

import java.io.IOException;
import java.net.ServerSocket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(57001,5)){
        while(true){
            new Thread(new ServerHandler(serverSocket.accept())).start();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}