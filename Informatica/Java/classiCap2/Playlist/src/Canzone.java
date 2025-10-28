public class Canzone {
    private String titolo;
    private int minuti;
    private int secondi;
    private String artista;

    public Canzone(String titolo, int minuti, int secondi, String artista) {
        this.titolo = titolo;
        this.minuti = minuti;
        this.secondi = secondi;
        this.artista = artista;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + "\nDurata: " + minuti + " minuti e " + secondi + " secondi\nArtista: " + artista;
    }
}
