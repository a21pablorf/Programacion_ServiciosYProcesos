import java.io.File;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "tracert", "www.google.com");

        var fileName= new File("L:\\ProgramacionServizos\\DU1\\tracer.txt");
        try {
            pb.redirectOutput(fileName);

            Process p = pb.start();

            p.waitFor();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}