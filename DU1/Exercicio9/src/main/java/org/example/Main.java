package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
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


       for(File archivo:archivos){
           double sumaArchivo= Suma.calcularSumaArchivo(archivo);
           System.out.println("El archivo: "+ archivo.getName()+ " suma: "+ sumaArchivo);
       }
    }
}