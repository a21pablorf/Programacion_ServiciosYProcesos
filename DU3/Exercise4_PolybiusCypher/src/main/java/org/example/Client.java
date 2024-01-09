package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        String message="HOLA";
        try {
            socket=new Socket("localhost",8080);
            System.out.println("Client connected");
            //Read from socket
            String response= Files.readString((Path) socket.getInputStream());
            System.out.println("Response from server: "+response);
            socket.close();
        }catch (Exception e){
            System.err.println("Erro na conexion por parte de cliente "+e.getMessage());
        }
    }

    public static void writeToSocket(Socket socket, String message) throws IOException {
        PrintWriter msgOut = new PrintWriter(socket.getOutputStream(), true);
        msgOut.println(message);
    }
}
