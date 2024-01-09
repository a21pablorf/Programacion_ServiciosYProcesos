import java.io.IOException;
import java.util.Map;

/**
 * Primeiro
 */
public class Primeiro {

    public static void main(String[] args)  {
        ProcessBuilder pb= new ProcessBuilder("cmd.exe", "/c", "echo", "hola mundo");

        pb.inheritIO();

        //pb.directory(new File("L:\\ProgramacionServizos\\DU1\\Exercise4"));

        try {
            Process proceso=pb.start();

            int retorno=proceso.waitFor();

            System.out.println("O comando devolveu: " + retorno);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(pb.directory());

        Map<String, String> env = pb.environment();


        env.forEach((s,s2) -> System.out.println(s + " = " + s2));
    }
}