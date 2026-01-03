import java.util.ArrayList;

public class Domanda {
    private String testo;
    private ArrayList<String> risposte;
    private int corretta;

    public Domanda(String testo, ArrayList<String> risposte, int corretta) {
        if (risposte.size() != 4 || corretta < 0 || corretta > 3)
            throw new IllegalArgumentException("Formato domanda non valido");

        this.testo = testo;
        this.risposte = risposte;
        this.corretta = corretta;
    }

    public boolean verifica(int scelta) {
        return scelta == corretta;
    }

    public void stampa() {
        System.out.println(testo);
        for (int i = 0; i < risposte.size(); i++) {
            System.out.println(i + ") " + risposte.get(i));
        }
    }
}
