package com.example2.demo.realEstateAgency.rest;

public class Building {

    private double surface;
    private double price;
    private boolean finished;

    public Building() {
    }

    public Building(double surface, double price, boolean finished) {
        this.surface = surface;
        this.price = price;
        this.finished = finished;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
