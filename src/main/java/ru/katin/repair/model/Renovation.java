package ru.katin.repair.model;

public abstract class Renovation {
    private String address;
    private double s;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getS() {
        return s;
    }

    public abstract double calculateCost();
}
