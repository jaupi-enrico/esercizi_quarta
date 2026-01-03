import java.io.Serializable;

public class Partita implements Serializable {
    public String giocatore;
    public int punteggio;

    public Partita(String nome) {
        this.giocatore = nome;
        this.punteggio = 0;
    }
}
