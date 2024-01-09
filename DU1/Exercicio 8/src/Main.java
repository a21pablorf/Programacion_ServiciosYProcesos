import java.io.*;

public class Main {

    public static void countVowel(String v, File ent, File ex) throws IOException {
        int c=0;

        String line;

        FileReader fr=new FileReader(ent);

        BufferedReader br=new BufferedReader(fr);

        while ((line=br.readLine()) != null){
            for (int i = 0; i < line.length(); i++) {
                if (Character.toUpperCase(line.charAt(i))==Character.toUpperCase(v.charAt(0))){
                    c++;
                }
            }
        }
        br.close();

        BufferedWriter bw=new BufferedWriter(new FileWriter(ex));

        bw.write(String.valueOf(c));

        bw.close();


    }

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        File dataFile= new File(args[0]);
        String vowel=args[1];
        File dataRes=new File(args[2]);

        countVowel(vowel,dataFile,dataRes);

    }

}