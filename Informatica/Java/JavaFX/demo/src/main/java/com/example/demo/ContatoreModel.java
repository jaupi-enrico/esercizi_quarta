package com.example.demo;

public class ContatoreModel {
    private long contatore;

    public ContatoreModel() {
        contatore = 0;
    }

    public long getContatore() {
        return contatore;
    }

    public void setContatore(long contatore) {
        this.contatore = contatore;
    }

    public void next() {
        this.contatore++;
    }

    @Override
    public String toString() {
        return Long.toString(contatore);
    }
}