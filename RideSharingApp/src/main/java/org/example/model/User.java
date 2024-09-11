package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private char gender;
    private List<Vehicle> vehicleList;
    private int age;
    private int ridetaken;
    private int rideOffered;

    public User(String name, char gender, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.vehicles = new ArrayList<>();
        this.age = age;
        this.ridetaken = 0;
        this.rideOffered = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public void addVehicle(Vehicle v) {
        vehicleList.add(v);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRidetaken() {
        return ridetaken;
    }

    public void setRidetaken(int ridetaken) {
        this.ridetaken = ridetaken;
    }

    public int getRideOffered() {
        return rideOffered;
    }

    public void setRideOffered(int rideOffered) {
        this.rideOffered = rideOffered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", vehicles=" + vehicles +
                ", age=" + age +
                ", ridetaken=" + ridetaken +
                ", rideOffered=" + rideOffered +
                '}';
    }
}
