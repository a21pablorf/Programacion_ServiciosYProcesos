package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        Socket socket;
        String message="hola";
        try {
            socket=new Socket("10.21.0.11",50001);
            System.out.println("Client connected");
            //Write to socket(server)
            writeToSocket(socket,message);
            System.out.println("Message sent to server");
            //Read from socket(server)
            String encryptedMessage=readFromSocket(socket);
            System.out.println("Encrypted message from server: "+encryptedMessage);
            socket.close();
        }catch (Exception e){
            System.err.println("Erro na conexion por parte de cliente "+e.getMessage());
        }
    }

    public static void writeToSocket(Socket socket, String message) throws IOException {
        PrintWriter msgOut = new PrintWriter(socket.getOutputStream(), true);
        msgOut.println(message);
    }

    protected static String readFromSocket(Socket sock) throws IOException {
        InputStream iStream = sock.getInputStream();
        String str="";
        char c;
        while ( ( c = (char) iStream.read() ) != '\n')
            str = str + c + "";
        return str;
    }
}
