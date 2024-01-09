package org.example;

import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        File f=new File("C:\\Users\\a21pablorf\\Desktop\\Apuntes 2021-2022.rar");

        ProcessBuilder pb=new ProcessBuilder("cmd.exe", "/c", "certutil", "-hashfile", f.getPath(), "MD5");

        pb.inheritIO();
        pb.start();
    }
}