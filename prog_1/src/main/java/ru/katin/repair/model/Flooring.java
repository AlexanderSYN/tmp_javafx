package ru.katin.repair.model;

public class Flooring extends Renovation {
    private double s;

    public Flooring(String address, double s) {
        super(address);
        this.s = s;
    }

    @Override
    public double calculateCost() {
        return 1200 * s;
    }
}
