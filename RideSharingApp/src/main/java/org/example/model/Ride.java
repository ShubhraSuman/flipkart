package org.example.model;

import java.time.LocalDate;

public class Ride {
    private User rideGiver;
    private String origin;
    private String destination;
    private Vehicle vehicle;
    private LocalDate startTime;
    private int numberOfSeatsAvailable;
    private int ride_duration;

    public Ride(String origin, String destination, Vehicle vehicle, LocalDate startTime, int numberOfSeatsAvailable) {
        this.origin = origin;
        this.destination = destination;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    public User getRideGiver() {
        return rideGiver;
    }

    public void setRideGiver(User rideGiver) {
        this.rideGiver = rideGiver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public int getNumberOfSeatsAvailable() {
        return numberOfSeatsAvailable;
    }

    public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    public int getRide_duration() {
        return ride_duration;
    }

    public void setRide_duration(int ride_duration) {
        this.ride_duration = ride_duration;
    }
}
