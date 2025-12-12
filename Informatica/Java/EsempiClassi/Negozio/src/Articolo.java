public class Articolo {
    private String codice;
    private String descrizione;
    private double prezzo;

    public Articolo(String codice, String descrizione, double prezzo) {
        setCodice(codice);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo < 0) {
            prezzo = -prezzo;
        }
        this.prezzo = prezzo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
