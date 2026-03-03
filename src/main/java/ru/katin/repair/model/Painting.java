package ru.katin.repair.model;

public class Painting extends Renovation {
    private double s;

    public void setS(double s) {
        this.s = s;
    }

    public double getS() {
        return s;
    }

    @Override
    public double calculateCost() {
        return 500 * s;
    }
}
