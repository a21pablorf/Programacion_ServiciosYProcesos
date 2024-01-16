package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SquareClientHandler(Socket accept) {
        this.clientSocket = accept;
    }
    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Message from client: " + inputLine);
                out.println(inputLine);
            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Erro na conexion por parte de servidor " + e.getMessage());
        }
    }
}
