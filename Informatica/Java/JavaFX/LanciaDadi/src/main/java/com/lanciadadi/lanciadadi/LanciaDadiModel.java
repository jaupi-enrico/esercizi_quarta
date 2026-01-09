package com.lanciadadi.lanciadadi;

public class LanciaDadiModel {
    private int nDadi;
    private int typeDadi;

    public LanciaDadiModel() {
        setnDadi(1);
        setTypeDadi(6);
    }

    public int getnDadi() {
        return nDadi;
    }

    public void setnDadi(int nDadi) {
        this.nDadi = nDadi;
    }

    public int getTypeDadi() {
        return typeDadi;
    }

    public void setTypeDadi(int typeDadi) {
        this.typeDadi = typeDadi;
    }

    public int lancia() {
        TazzaPerDadi tazza = new TazzaPerDadi(nDadi, typeDadi);
        return tazza.lancia();
    }
}