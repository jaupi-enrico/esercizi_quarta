public class Test {
    private String titolo;
    private Domanda[] domande;
    private int numeroDomande;

    public Test(String titolo) {
        this.titolo = titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = 0;
    }

    public Test(Test q) {
        this.titolo = q.titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = q.numeroDomande;
        for (int i = 0; i < numeroDomande; i++) {
            this.domande[i] = new Domanda(q.domande[i]);
        }
    }

    public boolean add(Domanda d) {
        if (numeroDomande >= 100) {
            return false;
        }
        domande[numeroDomande++] = d;
        return true;
    }

    public int getQuanteDomande() {
        return numeroDomande;
    }

    public int getQuanteRisposte() {
        int count = 0;
        for (int i = 0; i < numeroDomande; i++) {
            if (domande[i].completata())
                count++;
        }
        return count;
    }

    public int[] getDomandeNonDate() {
        int count = 0;
        for (int i = 0; i < numeroDomande; i++) {
            if (!domande[i].completata()) {
                count++;
            }
        }

        int[] filtered = new int[count];
        int indice = 0;
        for (int i = 0; i < numeroDomande; i++) {
            if (!domande[i].completata()) {
                filtered[indice++] = i + 1;
            }
        }

        return filtered;
    }

    public Domanda getDomanda(int n) {
        if (n < 1 || n > numeroDomande) {
            return null;
        }
        return domande[n - 1];
    }

    public double getTotale() {
        double totale = 0;
        for (int i = 0; i < numeroDomande; i++) {
            totale += domande[i].getValore();
        }
        return totale;
    }

    public double getPunteggio() {
        double punteggio = 0;
        for (int i = 0; i < numeroDomande; i++) {
            double p = domande[i].getPunteggio();
            if (p > 0) {
                punteggio += p;
            }
        }
        return punteggio;
    }

    @Override
    public String toString() {
        String s = "Quiz: " + titolo + "\n";
        s += "Numero domande: " + numeroDomande + "\n";
        s += "Punteggio totale: " + getTotale() + " punti";
        return s;
    }
}
