package org.example;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws SocketException, UnknownHostException {
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Your IP Address: " + localHost.getHostAddress());

        NetworkInterface nif = NetworkInterface.getByInetAddress(localHost);
        //mask for my ip
        System.out.println("Mask: " + nif.getInterfaceAddresses().get(0).getNetworkPrefixLength());

        String myIp=localHost.getHostAddress();
        int mask=nif.getInterfaceAddresses().get(0).getNetworkPrefixLength();

        int limit= (int) Math.pow(2,(32-mask)-2);

        for (int i = 0; i < limit; i++) {

        }


       // 1 .. 2?(32-prefix)



//        do {
//            while((Byte.toUnsignedInt(hostIp[2]))<255){
//                try {
//                    if (localHost.isReachable(100)){
//                        System.out.println("Host: " + Arrays.toString(hostIp) + " is reachable");
//                    }
//                    else{
//                        System.out.println("Host: " + Arrays.toString(hostIp) + " is not reachable");
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                hostIp[3]++;
//            }
//            hostIp[2]++;
//        }while ((Byte.toUnsignedInt(hostIp[3]))<255);

    }
} 