package org.example;

public enum ServerProtocol {
    //OK NICK. Indicates that the nick the client wants to use is valid. The server must inform the other clients about new connected clients.
    //OK BCAST. Indicates that the broadcast operation was successful
    //UNKNOWN. Indicates that the command does not exist in the communication protocol.
    //ERROR. Indicates that the command exists in the communication protocol but its use is incorrect.
    //BYE. Indicates that the communication with the client is going to be closed. The server must inform the other clients about disconnected clients.
    OK_NICK, OK_BCAST, UNKNOWN, ERROR, BYEM;

    public static ServerProtocol fromValue(String value) {
        return switch (value) {
            case "10" -> OK_NICK;
            case "11" -> BYEM;
            case "15" -> OK_BCAST;
            case "90" -> UNKNOWN;
            case "80" -> ERROR;
            default -> null;
        };
    }
}
