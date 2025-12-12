public class Cliente {
    private String codiceTessera;
    private long punti;
    private String nome;
    private Carrello carrello;

    public Cliente(String nome) {
        carrello = new Carrello();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public long getPunti() {
        return punti;
    }

    public String getCodiceTessera() {
        return codiceTessera;
    }

    public void setTessera(String codiceTessera, long punti) {
        this.codiceTessera = codiceTessera;
        this.punti = punti;
    }

    public void addPunti(long punti) {
        this.punti += punti;
    }
}
