import java.time.Instant;

public class Operazione {
    private double importo;
    private String causale;
    private int metodo;
    private Instant data;

    public Operazione(String causale, double importo, int metodo) {
        this.causale = causale;
        this.importo = importo;
        if (metodo == 1) {
            this.metodo = 1;
        }
        else {
            this.metodo = 2;
        }
        this.data = Instant.now();
    }

    public double getImporto() {
        return importo;
    }

    public String getCausale() {
        return causale;
    }

    public Instant getIstante() {
        return data;
    }

    public boolean isPrelievo() {
        return this.metodo == 1;
    }

    public boolean isDeposito() {
        return this.metodo == 2;
    }

    @Override
    public String toString() {
        String s = "Deposito di " + importo + "€, effettuato il " + data + ", con la seguente causale:\n";
        s += causale;
        return s;
    }
}
