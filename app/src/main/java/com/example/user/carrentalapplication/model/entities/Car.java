package com.example.user.carrentalapplication.model.entities;

/**
 * Created by User on 12/04/2018.
 */

public class Car {
    private int branchNumber;
    private long model;
    private long kilometers;
    private long carNumber;

    public Car() {
    }

    public Car(int branchNumber, long modelNum, long kilometers, long carNumber) {
        this.branchNumber = branchNumber;
        this.model = modelNum;
        this.kilometers = kilometers;
        this.carNumber = carNumber;
    }

    public int getBranchNumber() {return branchNumber;}

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(long model) {
        this.model = model;
    }

    public long getKilometers() {
        return kilometers;
    }

    public void setKilometers(long kilometers) {
        this.kilometers = kilometers;
    }

    public long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(long carNumber) {
        this.carNumber = carNumber;
    }
}
