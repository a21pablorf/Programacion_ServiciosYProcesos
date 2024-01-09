package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Test {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces =NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface=networkInterfaces.nextElement();
                System.out.println(networkInterface.getDisplayName());

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()){
                    InetAddress inetAddress=inetAddresses.nextElement();
                    System.out.println("\t"+inetAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}