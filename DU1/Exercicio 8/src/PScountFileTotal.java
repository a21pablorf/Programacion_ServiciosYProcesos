import java.io.File;
import java.io.IOException;

public class PScountFileTotal {
    public static void main(String[] args) throws IOException, InterruptedException {
        File fileOrigin=new File(args[0]);

        String[] vowels={"A","E","I","O","U"};

        String[] outFileNames=new String[vowels.length];
        Process[] processes=new Process[vowels.length];


        for (int i = 0; i < vowels.length; i++) {
            String classpath=System.getProperty("java.class.path");
            outFileNames[i]=vowels[i]+".txt";
            ProcessBuilder pb=new ProcessBuilder("java","-cp",classpath,args[1], args[0], vowels[i],outFileNames[i]);
            pb.start();

        }

        for (int i = 0; i < vowels.length; i++) {
            if (processes[i].isAlive()){
                processes[i].waitFor();
            }
        }
    }
}
