package org.example;

import java.io.*;

public class Main {
    public static void calcularSumaArchivo(File archivo,File saida){
        double total=0.0;

        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea=br.readLine()) != null){
                double numero=Double.parseDouble(linea);
                total+=numero;
            }
        }
        catch (NumberFormatException | IOException ex){
            System.out.println("Erro");
        }


        try (BufferedWriter bw=new BufferedWriter(new FileWriter(saida,true))){
            bw.write("Archivo: "+archivo.getName()+" tiene el valor: "+String.valueOf(total)+" \n");
        } catch (IOException e) {
            System.out.println("Erro no arquivo de saida");
        }

    }


    public static void main(String[] args) {
        File archivo=new File(args[0]);
        File saida=new File(args[1]);

        calcularSumaArchivo(archivo,saida);
    }
}