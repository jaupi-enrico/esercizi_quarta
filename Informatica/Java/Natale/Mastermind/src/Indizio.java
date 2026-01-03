public class Indizio {
    private int bianchi;
    private int neri;

    public Indizio(int bianchi, int neri) {
        this.bianchi = bianchi;
        this.neri = neri;
    }

    public int getBianchi() {
        return bianchi;
    }

    public int getNeri() {
        return neri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bianchi; i++) sb.append("b ");
        for (int i = 0; i < neri; i++) sb.append("n ");
        return sb.toString().trim();
    }
}
