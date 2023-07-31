package com.example2.demo.realEstateAgency.repository;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "surface")
    private double surface;
    @Column(name = "price")
    private double price;
    @Column(name = "finished")
    private boolean finished;

    public BuildingEntity() {
    }

    public BuildingEntity(int id, double surface, double price, boolean finished) {
        this.id = id;
        this.surface = surface;
        this.price = price;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BuildingEntity{" +
                "id=" + id +
                ", surface=" + surface +
                ", price=" + price +
                ", finished=" + finished +
                '}';
    }
}
