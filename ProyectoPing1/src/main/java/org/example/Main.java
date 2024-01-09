package org.example;

public class Main {
    public static void main(String[] args) {
        //String currentDirectory = System.getProperty("user.dir");
                                    //"gnome-terminal -- bash -c \"ping www.google.es\""
        ProcessBuilder p1 = new ProcessBuilder("gnome-terminal", "-- bash -c", "cd /home", "ls");

        p1.redirectErrorStream(true); 



        System.out.println("The default working directory is: " + p1.directory());
    }
}