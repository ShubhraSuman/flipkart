package org.example.model;

public class Vehicle {
    private String ids;
    private String owner;
    private String Model;
    private String RegNo;

    public Vehicle(String owner, String model, String regNo) {
        this.owner = owner;
        Model = model;
        RegNo = regNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }
}
