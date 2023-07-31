package com.example2.demo.salut;


public class Saluta {
    private static int numara;
    private String nume;

    public Saluta(int numara, String nume) {
        this.nume = nume;
        this.numara = numara;
    }

    public int getNumara() {
        return numara;
    }

    public String getNume() {
        return nume;
    }
}