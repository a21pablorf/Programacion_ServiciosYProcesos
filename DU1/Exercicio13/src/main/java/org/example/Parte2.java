package org.example;

import java.util.Scanner;

public class Parte2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int sum=0;

        for (int i = 0; i < n; i++) {
            sum= (int) (sum+ Math.pow(sc.nextInt(),2));
        }
        System.out.println(sum);
    }
}