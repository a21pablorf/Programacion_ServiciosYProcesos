package org.example;

import java.io.File;
import java.io.IOException;

public class PadreMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        File[] archivos= {
                new File("department101.txt"),
                new File("department102.txt"),
                new File("department103.txt"),
                new File("department104.txt"),
                new File("department105.txt"),
                new File("department106.txt"),
                new File("department107.txt"),
                new File("department108.txt")
        };

        File salida=new File("salida.txt");

        Process[] procesos=new Process[archivos.length];
        int c=0;

        for(File archivo:archivos){
            String classpath=System.getProperty("java.class.path");
            ProcessBuilder pb =new ProcessBuilder("java","-cp",classpath, "org.example.Main",archivo.getName(),salida.getName());
            procesos[c]=pb.start();
            c++;
            //System.out.println("El archivo: "+ archivo.getName()+ " suma: "+ pb.redirectOutput());
        }

        for (int i = 0; i < archivos.length; i++) {
            if(procesos[i].isAlive()){
                procesos[i].waitFor();
            }
        }


    }
}
