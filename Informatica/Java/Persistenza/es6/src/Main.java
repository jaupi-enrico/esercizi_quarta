import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        long righe = 0;
        long caratteri = 0;
        long parole = 0;

        try {
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);
            String riga;

            while ((riga = br.readLine()) != null) {
                righe++;

                caratteri += riga.length();

                if (!riga.trim().isEmpty()) {
                    String[] parts = riga.trim().split(" ");
                    parole += parts.length;
                }
            }

            br.close();
            fr.close();

            System.out.println("Righe: " + righe);
            System.out.println("Parole: " + parole);
            System.out.println("Caratteri: " + caratteri);

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
