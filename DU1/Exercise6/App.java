package Exercise6;

import java.io.File;

public class App {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "findstr", "/C:hola", "L:\\ProgramacionServizos\\DU1\\ejemplo.txt","|","find", "/c","/v","");
        //ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "find", "/C", "hola", "L:\\ProgramacionServizos\\DU1\\ejemplo.txt");

        var fileName=new File("archivo.txt");

        try {
            pb.redirectOutput(fileName);

            Process p = pb.start();

            p.waitFor();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
