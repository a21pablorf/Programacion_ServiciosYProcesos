package org.example;

import java.net.ServerSocket;
import java.net.Socket;

public class SquareMultiServer {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        SquareMultiServer server = new SquareMultiServer();
        server.begin(10);
    }

    private void begin(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening");
            while (true) {
                new Thread(new SquareClientHandler(serverSocket.accept())).start();
            }
        } catch (Exception e) {
            System.err.println("Erro na conexion por parte de servidor " + e.getMessage());
        }
        finally {
            stop();
        }
    }

    private void stop() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Erro ao fechar o socket do servidor " + e.getMessage());
        }
    }
}
