package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket port;
        try {
            port=new ServerSocket(22);
            System.out.println("Server is listening");
            socket=port.accept();
            System.out.println("Client connected");
            //Read from socket(client)
            String message=readFromSocket(socket);
            System.out.println("Message from client: "+message);
            //Write to socket(client)
            writeToSocket(socket,encrypt(message));
            System.out.println("Encrypted message sent to client");
            socket.close();
        }catch (Exception e){
            System.err.println("Erro na conexion por parte de servidor "+e.getMessage());
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

    public static String encrypt(String message){
        message=message.toLowerCase();
        Character[][] matrix={
                {'a','b','c','d','e','f'},
                {'g','h','i','j','k','l'},
                {'m','n','o','p','q','r'},
                {'s','t','u','v','w','x'},
                {'y','z','0','1','2','3'},
                {'4','5','6','7','8','9'}
        };

        String encryptedMessage="";

        for(int i=0;i<message.length();i++){
            for(int j=0;j<6;j++){
                for(int k=0;k<6;k++){
                    if(message.charAt(i)==matrix[j][k]){
                        encryptedMessage+=j+1;
                        encryptedMessage+=k+1;
                        encryptedMessage+=" ";
                    }
                }
            }
        }
        return encryptedMessage;
    }

    //Method to decrypt the message with polybius square


}
