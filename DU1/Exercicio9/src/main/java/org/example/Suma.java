package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Suma {
    public static double calcularSumaArchivo(File archivo){
        double total=0.0;

        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea=br.readLine()) != null){
                double numero=Double.parseDouble(linea);
                total+=numero;
            }
        }
        catch (IOException ex){
            System.out.println("Erro");
        }
        catch (NumberFormatException ex){
            System.out.println("ERRO");
        }

        return total;
    }
}
