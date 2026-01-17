package net.imparando.daditesto;

import java.util.ArrayList;
import java.util.List;

public class TazzaPerDadi {
    private List<Dado> dadi;

    /**
     *
     * @param n numero di dadi
     * @param f numero di facce
     */
    public TazzaPerDadi(int n, int f) throws Exception {
        if (n < 1){
            throw new Exception("Numero di dadi non valido");
        }
        dadi = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dadi.add(new Dado(f));
        }
    }

    public int lancia(){
        int somma = 0;
        for (Dado dado : dadi) {
            somma += dado.lancia();
        }
        return somma;
    }
}
