import java.io.*;
import java.util.*;

public class Categoria {
    private String nome;
    private ArrayList<Domanda> domande = new ArrayList<>();

    public Categoria(String nome, String file) throws IOException {
        this.nome = nome;
        caricaDaFile(file);
    }

    private void caricaDaFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        try {
            while ((linea = br.readLine()) != null) {
                String testo = linea;
                ArrayList<String> risposte = new ArrayList<>();

                for (int i = 0; i < 4; i++)
                    risposte.add(br.readLine());

                int corretta = Integer.parseInt(br.readLine());

                domande.add(new Domanda(testo, risposte, corretta));

                br.readLine();
            }
        } catch (Exception e) {
            throw new IOException("Errore formato file: " + file);
        }
    }

    public Domanda domandaCasuale() {
        return domande.get(new Random().nextInt(domande.size()));
    }

    public String getNome() {
        return nome;
    }
}
