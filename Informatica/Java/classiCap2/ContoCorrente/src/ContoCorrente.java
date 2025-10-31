import java.time.Instant;
import java.time.LocalDate;

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

    public void eseguiOperazione(Operazione o) {
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
            eseguita = false;
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
        return attuale;
    }



    public Operazione[] getPrelievi() {
        int count = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].isPrelievo() && eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].isPrelievo() && eseguita[i]) {
                filter[attuale] = operazioni[i];
            }
        }
        return filter;
    }

    public Operazione[] getDepositi() {
        int count = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].isDeposito()) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].isDeposito()) {
                filter[attuale] = operazioni[i];
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniImportanti() {
        int count = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].getImporto() > 100) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].getImporto() > 100) {
                filter[attuale] = operazioni[i];
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniNonEseguite() {
        int count = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(!eseguita[i]) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(!eseguita[i]) {
                filter[attuale] = operazioni[i];
            }
        }
        return filter;
    }

    public Operazione[] getOperazioniMese(int mese) {
        int count = 0;

        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(operazioni[i].getIstante().isAfter() && i) {
                count++;
            }
        }
        Operazione[] filter = new Operazione[count];
        int attuale = 0;
        for (int i = 0; i < getNumeroOperazioni(); i++) {
            if(!eseguita[i]) {
                filter[attuale] = operazioni[i];
            }
        }
        return filter;
    }
}
