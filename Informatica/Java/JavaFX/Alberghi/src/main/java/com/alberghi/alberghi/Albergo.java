package com.alberghi.alberghi;

import java.time.LocalDate;

public class Albergo {
    private String nome;
    private double prezzo;

    public Albergo(String nome, double prezzo) {
        setNome(nome);
        setPrezzo(prezzo);
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo < 0 ) {
            this.prezzo = -prezzo;
        }
        else {
            this.prezzo = prezzo;
        }
    }

    @Override
    public String toString() {
        return nome;
    }

    public double calcolaPrezzo(LocalDate start, LocalDate end) {
        long days = 0;
        while (end.isAfter(start)) {
            end = end.minusDays(1);
            days++;
        }
        return getPrezzo() * days;
    }
}
