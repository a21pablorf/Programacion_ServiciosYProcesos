package org.example;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Game game;
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                DataInputStream reader = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream())
        ) {
            String commandServer=Protocol.READY;
            writer.writeUTF(Protocol.READY);

            while (commandServer!=Protocol.BYE){
                String clientMessage=reader.readUTF();
                String[] command=clientMessage.split(" ");

                switch (command[0]){
                    case "NEW":
                        int maxAttempts=Integer.parseInt(command[1]);
                        game=new Game(maxAttempts);
                        writer.writeUTF(Protocol.PLAY);
                        break;
                    case "NUM":
                        if (game!=null){
                            int userGuess = Integer.parseInt(command[1]);
                            String responseCode = game.guess(userGuess);

                            if (responseCode.equals(Protocol.WIN)) {
                                writer.writeUTF(Protocol.WIN);
                                commandServer=Protocol.BYE;
                            }
                            if(responseCode.equals(Protocol.LOSE)){
                                writer.writeUTF(Protocol.LOSE);
                                commandServer=Protocol.BYE;
                            }
                            if(responseCode.equals(Protocol.LOW)){
                                writer.writeUTF(Protocol.LOW);
                            }
                            if(responseCode.equals(Protocol.HIGH)){
                                writer.writeUTF(Protocol.HIGH);
                            }
                        }else{
                            writer.writeUTF(Protocol.ERR);
                        }
                        break;

                    case "HELP":
                        writer.writeUTF(Protocol.INFO+"Commands: NEW, NUM, HELP, QUIT");
                        break;

                    case "QUIT":
                        writer.writeUTF("Bye!");
                        commandServer=Protocol.BYE;
                        break;

                    default:
                        writer.writeUTF(Protocol.UNKNOWN);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el client handler "+e.getMessage());
        }
    }
}
