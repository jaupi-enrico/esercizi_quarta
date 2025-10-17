public class OrologioDigitale {
    private int ore;
    private int minuti;
    private int ore_sveglia;
    private int minuti_sveglia;
    private int stato;
    private boolean statoOre;
    private boolean statoSveglia;

    public OrologioDigitale() {
        ore = 0;
        minuti = 0;
        ore_sveglia = 0;
        minuti_sveglia = 0;
        stato = 1;
        statoOre = true;
        statoSveglia = false;
    }

    public OrologioDigitale(int ore, int minuti) {
        if (ore >= 0 && ore < 24 && minuti >= 0 && minuti < 60) {
            this.ore = ore;
            this.minuti = minuti;
        }
        ore_sveglia = 0;
        minuti_sveglia = 0;
        stato = 1;
        statoOre = true;
        statoSveglia = false;
    }

    public void impostaOrario() {
        if (stato != 2) {
            stato = 2;
            statoOre = true;
            return;
        }
        stato = 1;
    }

    public void impostaSveglia() {
        if (stato != 3) {
            stato = 3;
            statoOre = true;
            return;
        }
        stato = 1;
    }

    public void aumenta() {
        if (stato == 2) {
            if (statoOre) {
                if (ore == 23) {
                    ore = 0;
                    return;
                }
                ore++;
                return;
            }
            if (minuti == 59) {
                minuti = 0;
                return;
            }
            minuti++;
        } else if (stato == 3) {
            if (statoOre) {
                if (ore_sveglia == 23) {
                    ore_sveglia = 0;
                    return;
                }
                ore_sveglia++;
                return;
            }
            if (minuti_sveglia == 59) {
                minuti_sveglia = 0;
                return;
            }
            minuti_sveglia++;
        }
    }

    public void diminuisci() {
        if (stato == 2) {
            if (statoOre) {
                if (ore == 0) {
                    ore = 23;
                    return;
                }
                ore--;
                return;
            }
            if (minuti == 0) {
                minuti = 59;
                return;
            }
            minuti--;
        } else if (stato == 3) {
            if (statoOre) {
                if (ore_sveglia == 0) {
                    ore_sveglia = 23;
                    return;
                }
                ore_sveglia--;
                return;
            }
            if (minuti_sveglia == 0) {
                minuti_sveglia = 59;
                return;
            }
            minuti_sveglia--;
        }
    }

    public void toggleOreMinuti() {
        if (stato != 1) {
            statoOre = !statoOre;
        }
    }

    public void toggleSveglia() {
        statoSveglia = !statoSveglia;
    }

    private String styleNumber(int n) {
        if (n < 10) {
            return "0" + n;
        }
        else {
            return "" + n;
        }
    }

    @Override
    public String toString() {
        String s = "Orologio in modalità " + stato + ", regolazione ";
        if (statoOre) {
            s += "ore.\n";
        }
        else {
            s += "minuti.\n";
        }
        s += "Orario corrente " + styleNumber(ore) + ":" + styleNumber(minuti) + "\n";
        s += "Sveglia corrente " + styleNumber(ore_sveglia) + ":" + styleNumber(minuti_sveglia) + ", ";
        if (statoSveglia) {
            s += "attiva";
        }
        else {
            s += "spenta";
        }
        return s;
    }
}
