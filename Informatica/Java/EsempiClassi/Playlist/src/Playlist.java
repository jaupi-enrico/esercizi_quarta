public class Playlist {
    private int n;
    private String name;
    private String state;
    private int nCorrente;

    public Playlist(String name, int n) {
        this.n = n;
        this.name = name;
        this.state = "STOP";
        this.nCorrente = 1;
    }

    public Playlist(Playlist p) {
        this.n = p.n;
        this.name = p.name;
        this.state = p.state;
        this.nCorrente = p.nCorrente;
    }

    public String getName() {
        return name;
    }

    public int getQuantiBrani() {
        return n;
    }

    public void play() {
        state = "PLAY";
    }

    public void pause() {
        if (state.equals("STOP")) {
            return;
        }
        state = "PAUSE";
    }

    public void stop() {
        if (state.equals("STOP")) {
            nCorrente = 1;
            return;
        }
        state = "STOP";
    }

    public void branoSuccessivo() {
        if (nCorrente == n) {
            nCorrente = 1;
            return;
        }
        nCorrente++;
    }

    public void branoPrecedente() {
        if (nCorrente == 1) {
            nCorrente = n;
            return;
        }
        nCorrente--;
    }

    @Override
    public String toString() {
        return "Playlist " + name + ", " + n + " brani, in " + state + " sul brano " + nCorrente;
    }
}
