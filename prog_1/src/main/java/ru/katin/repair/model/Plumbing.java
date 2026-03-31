package ru.katin.repair.model;

public class Plumbing extends Renovation {
    private double s;

    public Plumbing(String address, double s) {
        super(address);
        this.s = s;
    }

    @Override
    public double calculateCost() {
        return 3000 * s;
    }
}
