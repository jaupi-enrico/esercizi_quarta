public class LampadinaIntelligente {
    private int potenza;
    private int quantitaIlluminazione;
    private String colore;
    private String nome;
    boolean accesa;

    public LampadinaIntelligente(int potenza) {
        this.potenza = potenza;
        this.quantitaIlluminazione = 50;
        this.nome = "";
        this.colore = "bianco";
        this.accesa = false;
    }

    public LampadinaIntelligente(LampadinaIntelligente l) {
        this.nome = l.nome;
        this.potenza = l.potenza;
        this.quantitaIlluminazione = l.quantitaIlluminazione;
        this.colore = l.colore;
        this.accesa = l.accesa;
    }

    public int getPotenza() {
        return this.potenza;
    }

    public String getColore() {
        return this.colore;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void accendi() {
        this.accesa = true;
    }

    public void spegni() {
        this.accesa = false;
    }

    public void aumentaIlluminazione() {
        if (quantitaIlluminazione <= 90) {
            quantitaIlluminazione += 10;
        }
        else {
            quantitaIlluminazione = 100;
        }
    }

    public void diminuisciIlluminazione() {
        if (quantitaIlluminazione >= 10) {
            quantitaIlluminazione -= 10;
        }
        else {
            quantitaIlluminazione = 0;
        }
    }

    @Override
    public String toString() {
       return "Nome: " + nome + ", Potenza: " + potenza + " watt, Stato: " + accesa + ", Qta: " + quantitaIlluminazione + "%, Colore: " + colore;
    }
}