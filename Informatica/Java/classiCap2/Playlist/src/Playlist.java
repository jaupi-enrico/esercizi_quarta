public class Playlist {
    private String name;
    private String state;
    private Canzone[] canzoni;
    private int n;
    private int nCorrente;

    public Playlist(String name, Canzone[] iniziale) {
        this.name = name;
        this.state = "STOP";
        this.canzoni = new Canzone[100];
        this.n = 0;
        for (Canzone c : iniziale) {
            add(c);
        }
        this.nCorrente = 1;
    }

    public Canzone getCanzone(int numero) {
        if (numero < 1 || numero > n) return null;
        return canzoni[numero - 1];
    }

    public boolean add(Canzone c) {
        if (n >= 100) return false;
        canzoni[n] = c;
        n++;
        return true;
    }

    public int[] durataTotale() {
        int totMinuti = 0;
        int totSecondi = 0;
        for (int i = 0; i < n; i++) {
            totMinuti += canzoni[i].getMinuti();
            totSecondi += canzoni[i].getSecondi();
        }
        totMinuti += totSecondi / 60;
        totSecondi = totSecondi % 60;
        return new int[]{totMinuti, totSecondi};
    }

    public void play()  { state = "PLAY"; }
    public void pause() { if (!state.equals("STOP")) state = "PAUSE"; }
    public void stop()  { state = "STOP"; nCorrente = 1; }

    public void branoSuccessivo() {
        if (nCorrente == n) nCorrente = 1;
        else nCorrente++;
    }

    public void branoPrecedente() {
        if (nCorrente == 1) nCorrente = n;
        else nCorrente--;
    }

    @Override
    public String toString() {
        String brano = (n == 0 ? "Nessun brano" :
                canzoni[nCorrente - 1].getTitolo() +
                        " di " + canzoni[nCorrente - 1].getArtista());
        return "Playlist " + name + ", " + n + " brani, in " + state +
                " sul brano " + brano;
    }
}
