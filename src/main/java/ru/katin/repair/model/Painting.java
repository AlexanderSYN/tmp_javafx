package ru.katin.repair.model;

public class Painting extends Renovation {
    private double s;

    public Painting(String address, double s) {
        super(address);
        this.s = s;
    }

    @Override
    public double calculateCost() {
        return 500 * s;
    }
}
