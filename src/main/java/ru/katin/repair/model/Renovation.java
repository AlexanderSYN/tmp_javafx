package ru.katin.repair.model;

public abstract class Renovation {
    private String address;

    public Renovation(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public abstract double calculateCost();
}
