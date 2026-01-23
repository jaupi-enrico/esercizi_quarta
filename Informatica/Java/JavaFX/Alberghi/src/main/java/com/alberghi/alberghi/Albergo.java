package com.alberghi.alberghi;

public class Albergo {
    private String nome;
    private Double prezzo;

    public String getNome() {
        return nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPrezzoGiorni(long giorni) {
        return giorni * prezzo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
