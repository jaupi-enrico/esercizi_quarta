import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Parola da sostituire: ");
        String parolaOriginale = in.next();

        System.out.print("Nuova parola: ");
        String parolaSostituita = in.next();

        String file;
        File f;
        while (true) {
            System.out.print("Nome file: ");
            file = in.next();
            f = new File(file);

            if (f.exists() && f.isFile()) break;

            System.out.println("Il file non esiste. Riprova.\n");
        }

        ArrayList<String> righe = new ArrayList<>();
        ArrayList<String> righeModificate = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String riga;

            while ((riga = br.readLine()) != null) {
                righe.add(riga);
            }

        } catch (IOException e) {
            System.out.println("Errore lettura: " + e);
            return;
        }

        for (int i = 0; i < righe.size(); i++) {
            String rigaOriginale = righe.get(i);
            String rigaNuova = rigaOriginale.replace(parolaOriginale, parolaSostituita);

            if (!rigaOriginale.equals(rigaNuova)) {
                righeModificate.add("- " + rigaOriginale);
                righeModificate.add("+ " + rigaNuova);
            }

            righe.set(i, rigaNuova);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (String riga : righe) {
                bw.write(riga);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Errore scrittura: " + e);
            return;
        }

        System.out.println("\nRighe modificate:");
        if (righeModificate.isEmpty()) {
            System.out.println("(nessuna riga modificata)");
        } else {
            for (String r : righeModificate) {
                System.out.println(r);
            }
        }
    }
}
