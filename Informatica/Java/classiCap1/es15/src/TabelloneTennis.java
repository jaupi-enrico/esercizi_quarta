public class TabelloneTennis {
    private String giocatore1;
    private String giocatore2;
    private int servizio;
    private int alMeglioDei;
    private boolean partitaFinita;
    private int setVinti1;
    private int setVinti2;
    private int game1;
    private int game2;
    private int punti1;
    private int punti2;
    private boolean tieBreak;

    public TabelloneTennis(String nome1, String nome2, int inizio, int tipo) {
        giocatore1 = nome1;
        giocatore2 = nome2;

        if (inizio == 2)
            servizio = 2;
        else
            servizio = 1;

        if (tipo == 5)
            alMeglioDei = 5;
        else
            alMeglioDei = 3;

        setVinti1 = 0;
        setVinti2 = 0;
        game1 = 0;
        game2 = 0;
        punti1 = 0;
        punti2 = 0;
        tieBreak = false;
        partitaFinita = false;
    }

    public void aggiungiPunto(int giocatore) {
        if (partitaFinita) {
            return;
        }

        if (tieBreak) {
            if (giocatore == 1)
                punti1++;
            else
                punti2++;

            if ((punti1 >= 7 || punti2 >= 7) && ((punti1 - punti2) >= 2 || (punti1 - punti2) <= -2)) {
                fineSet();
            }
            return;
        }

        if (giocatore == 1)
            punti1++;
        else
            punti2++;

        if (punti1 >= 4 || punti2 >= 4) {
            if ((punti1 - punti2) >= 2 || (punti1 - punti2) <= -2) {
                if (punti1 > punti2)
                    gameVinto(1);
                else
                    gameVinto(2);
            }
        }

        return;
    }

    private void gameVinto(int giocatore) {
        if (giocatore == 1)
            game1++;
        else
            game2++;

        punti1 = 0;
        punti2 = 0;

        if (servizio == 1)
            servizio = 2;
        else
            servizio = 1;

        if (game1 >= 6 && game1 - game2 >= 2)
            fineSet();
        else if (game2 >= 6 && game2 - game1 >= 2)
            fineSet();
        else if (game1 == 6 && game2 == 6)
            tieBreak = true;
        else if (game1 == 7 || game2 == 7)
            fineSet();
    }

    private void fineSet() {
        if (tieBreak) {
            if (punti1 > punti2)
                setVinti1++;
            else
                setVinti2++;
        } else {
            if (game1 > game2)
                setVinti1++;
            else
                setVinti2++;
        }

        game1 = 0;
        game2 = 0;
        punti1 = 0;
        punti2 = 0;
        tieBreak = false;

        if (setVinti1 == (alMeglioDei / 2 + 1) || setVinti2 == (alMeglioDei / 2 + 1))
            partitaFinita = true;
    }

    public String vittoria() {
        if (!partitaFinita) {
            return "";
        }
        if (setVinti1 > setVinti2)
            return giocatore1;
        else
            return giocatore2;
    }

    private String punteggioGiocatore(int punti, int altriPunti) {
        if (tieBreak)
            return "" + punti;

        if (punti >= 4 && altriPunti >= 4) {
            if (punti == altriPunti)
                return "40";
            if (punti > altriPunti)
                return "ADV";
            return "";
        }

        if (punti == 0)
            return "0";
        if (punti == 1)
            return "15";
        if (punti == 2)
            return "30";
        return "40";
    }

    public String toString() {
        String testo = giocatore1;
        if (servizio == 1)
            testo += " *";
        testo += "  " + setVinti1 + " " + game1 + " " + punteggioGiocatore(punti1, punti2) + "\n";

        testo += giocatore2;
        if (servizio == 2)
            testo += " *";
        testo += "  " + setVinti2 + " " + game2 + " " + punteggioGiocatore(punti2, punti1);

        return testo;
    }
}
