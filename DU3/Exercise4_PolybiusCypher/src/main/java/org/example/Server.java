package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket port;
        try {
            port=new ServerSocket(8080);
            System.out.println("Server is listening");
            socket=port.accept();
            System.out.println("Client connected");
            writeToSocket(socket,"HOLA");
            socket.close();
        }catch (Exception e){
            System.err.println("Erro na conexion por parte de servidor "+e.getMessage());
        }
    }

    public static void writeToSocket(Socket socket, String message) throws IOException {
        PrintWriter msgOut = new PrintWriter(socket.getOutputStream(), true);
        msgOut.println(message);
    }


}
