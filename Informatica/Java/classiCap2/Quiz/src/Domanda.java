public class Domanda {
    private String testo;
    private Risposta[] risposte;
    private double valore;
    private Integer rispostaUtente;

    public Domanda(String testo, Risposta[] risposte) {
        this.testo = testo;
        this.risposte = risposte;
        this.valore = 1;
        this.rispostaUtente = null;
    }

    // Costruttore di copia (senza la risposta utente)
    public Domanda(Domanda d) {
        this.testo = d.testo;
        this.valore = d.valore;
        this.risposte = new Risposta[d.risposte.length];
        for (int i = 0; i < d.risposte.length; i++) {
            this.risposte[i] = d.risposte[i];
        }
        this.rispostaUtente = null;
    }

    public boolean rispondi(int risposta) {
        if (risposta < 1 || risposta > 4) {
            return false;
        }
        this.rispostaUtente = risposta;
        return risposte[risposta - 1].isCorretta();
    }

    public void setValore(double valore) {
        if (valore > 0) {
            this.valore = valore;
        }
    }

    public double getValore() {
        return valore;
    }

    public double getPunteggio() {
        if (rispostaUtente == null) {
            return -1;
        }
        if (risposte[rispostaUtente - 1].isCorretta()) {
            return valore;
        }
        else {
            return 0;
        }
    }

    public boolean completata() {
        return rispostaUtente != null;
    }

    public String getRispostaCorretta() {
        for (Risposta r : risposte) {
            if (r.isCorretta()) {
                return r.getTesto();
            }
        }
        return null;
    }

    public String getRispostaData() {
        if (rispostaUtente == null) {
            return null;
        }
        return risposte[rispostaUtente - 1].getTesto();
    }

    @Override
    public String toString() {
        String s = testo + "\n";
        for (int i = 0; i < risposte.length; i++) {
            s += (i + 1) + ") " + risposte[i].getTesto() + "\n";
        }
        return s;
    }
}
