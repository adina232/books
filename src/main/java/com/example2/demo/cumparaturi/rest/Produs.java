package com.example2.demo.cumparaturi.rest;

public class Produs {
    private String numeProdus;
    private String tipCantitate;
    private double cantitate;

    public Produs() {
    }

    public Produs(String numeProdus, String tipCantitate, double cantitate) {
        this.numeProdus = numeProdus;
        this.tipCantitate = tipCantitate;
        this.cantitate = cantitate;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String produs) {
        this.numeProdus = produs;
    }

    public String getTipCantitate() {
        return tipCantitate;
    }

    public void setTipCantitate(String tipCantitate) {
        this.tipCantitate = tipCantitate;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }
}
