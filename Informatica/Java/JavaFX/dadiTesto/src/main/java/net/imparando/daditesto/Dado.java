package net.imparando.daditesto;

public class Dado {
    private int nFacce;

    public Dado(int nFacce) throws Exception {
        if (nFacce < 2 || nFacce == 3){
            throw new Exception("Numero di facce non valide.");
        }
        this.nFacce = nFacce;
    }

    public int lancia(){
        return (int)(Math.random() * nFacce) + 1;
    }
}
