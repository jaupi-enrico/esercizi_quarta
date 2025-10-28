public class TabellonePallavolo {
    private String nomeLocale;
    private String nomeOspite;
    private int puntiLocale;
    private int puntiOspite;
    private int setLocale;
    private int setOspite;
    private boolean serveLocale;
    private boolean serveOspite;
    private boolean oltranza;

    public TabellonePallavolo(String squadra1, String squadra2, int n) {
        nomeLocale = squadra1;
        nomeOspite = squadra2;
        if (n == 2) {
            serveOspite = true;
            serveLocale = false;
        }
        else {
            serveLocale = true;
            serveOspite = false;
        }
        oltranza = false;
    }

    public void puntoCasa() {
        if (oltranza && puntiLocale - puntiOspite == 2) {
            oltranza = false;
            puntiLocale = 0;
            puntiOspite = 0;
            setLocale++;
        }
        else if (!oltranza && puntiLocale == 25) {
            puntiLocale = 0;
            puntiOspite = 0;
            setLocale++;
        }
        else if (puntiLocale + 1 == 24 && puntiOspite == 24) {
            oltranza = true;
            puntiLocale++;
        }
        else
            puntiLocale++;
    }

    public void puntoOspiti() {
        if (oltranza && puntiOspite - puntiLocale == 2) {
            oltranza = false;
            puntiOspite = 0;
            puntiLocale = 0;
            setOspite++;
        }
        else if (!oltranza && puntiOspite == 25) {
            puntiLocale = 0;
            puntiOspite = 0;
            setOspite++;
        }
        else if (puntiOspite + 1 == 24 && puntiLocale == 24) {
            oltranza = true;
            puntiOspite++;
        }
        else
            puntiOspite++;
    }

    @Override
    public String toString() {
        String s = nomeLocale + " - " + nomeOspite + "\n";
        if (serveLocale)
            s += "*";
        s += "    " + puntiLocale + "      " + puntiOspite;
        if (serveOspite)
            s += "  *";
        s += "\n";
        s += "Set " + setLocale + "      " + setOspite;
        return s;
    }
}
