package org.example;

import java.io.IOException;
import java.net.*;

public class Ja {
    public static void main(String[] args) throws IOException {
        InetAddress localhost = InetAddress.getLocalHost();
        byte[] ip = localhost.getAddress();

        for(int i=1;i<=254;i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ip[3] = (byte)j;
                        InetAddress address = InetAddress.getByAddress(ip);

                        if (address.isReachable(100)) {
                            String output = address.toString().substring(1);
                            System.out.println(output + " is on the network");
                        }
                        else{
                            String output = address.toString().substring(1);
                            System.out.println(output + " is not on the network");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}

