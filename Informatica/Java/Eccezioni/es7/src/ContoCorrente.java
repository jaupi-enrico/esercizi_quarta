import java.time.LocalDate;
import java.time.ZoneId;

public class ContoCorrente {
    private String nome;
    private String cognome;
    private String codice;
    private double saldo;
    private Operazione[] operazioni;
    private boolean[] eseguita;
    private int attuale;

    public ContoCorrente(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
        this.operazioni = new Operazione[100];
        this.eseguita = new boolean[100];
        this.attuale = 0;
    }

    static class OperazioneNotValidEException extends Exception {
        private Operazione operazione;
        public OperazioneNotValidEException(Operazione o) {
            operazione = o;
        }

        @Override
        public String toString() {
            return "L'operazione non e' valida: " + operazione;
        }
    }

    public void eseguiOperazione(Operazione o) throws OperazioneNotValidEException {
        boolean eseguita;
        if (o.isPrelievo() && o.getImporto() <= saldo) {
            saldo -= o.getImporto();
            eseguita = true;
        }
        else if (o.isDeposito()) {
            saldo += o.getImporto();
            eseguita = true;
        }
        else {
            throw new OperazioneNotValidEException(o);
        }

        operazioni[attuale] = o;
        this.eseguita[attuale] = eseguita;
        attuale++;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCodice() {
        return codice;
    }

    public String getNominativo() {
        return nome + " " + cognome;
    }

    public Operazione getOperazione(int index) {
        if (index < 0 || index >= 100) {
            return null;
        }
        return operazioni[index];
    }

    public int getNumeroOperazioni() {
        int count = 0;
        for (int i = 0; i < attuale; i++) {
            if (eseguita[i]) {
                count++;
            }
        }
        return count;
    }



    public Operazione[] getPrelievi() {
        int count = 0;
        for (int i = 0; i < attuale; i++) {
            if(operazioni[i].isPrelievo() && eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            if(operazioni[i].isPrelievo() && eseguita[i]) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    public Operazione[] getDepositi() {
        int count = 0;
        for (int i = 0; i < attuale; i++) {
            if(operazioni[i].isDeposito()) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            if(operazioni[i].isDeposito()) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniImportanti() {
        int count = 0;
        for (int i = 0; i < attuale; i++) {
            if(operazioni[i].getImporto() > 100) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            if(operazioni[i].getImporto() > 100) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniNonEseguite() {
        int count = 0;
        for (int i = 0; i < attuale; i++) {
            if(!eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            if(!eseguita[i]) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniMese(int mese) {
        if (mese < 1 || mese > 12) {
            return new Operazione[0];
        }
        int count = 0;

        for (int i = 0; i < attuale; i++) {
            LocalDate data = LocalDate.ofInstant(operazioni[i].getIstante(), ZoneId.systemDefault());
            if (data.getMonthValue() == mese && eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            LocalDate data = LocalDate.ofInstant(operazioni[i].getIstante(), ZoneId.systemDefault());
            if(data.getMonthValue() == mese && eseguita[i]) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniAnno(int anno) {
        int count = 0;

        for (int i = 0; i < attuale; i++) {
            LocalDate data = LocalDate.ofInstant(operazioni[i].getIstante(), ZoneId.systemDefault());
            if (data.getYear() == anno && eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < this.attuale; i++) {
            LocalDate data = LocalDate.ofInstant(operazioni[i].getIstante(), ZoneId.systemDefault());
            if(data.getYear() == anno && eseguita[i]) {
                filter[attuale] = operazioni[i];
                attuale++;
            }
        }
        return filter;
    }

    @Override
    public String toString() {
        String s = "Conto di " + getNominativo() + " (codice " + getCodice() + ")\n";
        s += "Saldo attuale: " + getSaldo() + "\n";
        s += "Operazioni totali: " + attuale + " (eseguite: " + getNumeroOperazioni() + ")";
        return s;
    }
}
