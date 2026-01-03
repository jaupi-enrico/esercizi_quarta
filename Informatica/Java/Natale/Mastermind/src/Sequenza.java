import java.util.ArrayList;

public class Sequenza {
    private ArrayList<Integer> colori;

    public Sequenza() {
        colori = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            colori.add(Colore.casuale());
        }
    }

    public Sequenza(int c1, int c2, int c3, int c4) {
        colori = new ArrayList<>();
        colori.add(c1);
        colori.add(c2);
        colori.add(c3);
        colori.add(c4);
    }

    public int getColore(int i) {
        return colori.get(i);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Sequenza)) return false;
        Sequenza altra = (Sequenza) obj;

        for (int i = 0; i < 4; i++) {
            if (!this.colori.get(i).equals(altra.colori.get(i)))
                return false;
        }
        return true;
    }

    public Indizio confronta(Sequenza tentativo) {
        ArrayList<Boolean> usatoSegreto = new ArrayList<>();
        ArrayList<Boolean> usatoTent = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            usatoSegreto.add(false);
            usatoTent.add(false);
        }

        int neri = 0;
        int bianchi = 0;

        for (int i = 0; i < 4; i++) {
            if (this.colori.get(i).equals(tentativo.colori.get(i))) {
                neri++;
                usatoSegreto.set(i, true);
                usatoTent.set(i, true);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (usatoTent.get(i)) continue;
            for (int j = 0; j < 4; j++) {
                if (!usatoSegreto.get(j) &&
                        tentativo.colori.get(i).equals(this.colori.get(j))) {
                    bianchi++;
                    usatoSegreto.set(j, true);
                    break;
                }
            }
        }

        return new Indizio(bianchi, neri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int c : colori) {
            sb.append(Colore.toString(c)).append(" ");
        }
        return sb.toString().trim();
    }
}
