package org.example.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
    private String airline;
    private String sourceCity;
    private String desitinationCity;
    private double price;
    private boolean hasMeals;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Flight(String airline, String sourceCity, String desitinationCity, double price, boolean hasMeals) {
        this.airline = airline;
        this.sourceCity = sourceCity;
        this.desitinationCity = desitinationCity;
        this.price = price;
        this.hasMeals = hasMeals;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
    }

    public Flight(String airline, String sourceCity, String desitinationCity, double price, boolean hasMeals, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.airline = airline;
        this.sourceCity = sourceCity;
        this.desitinationCity = desitinationCity;
        this.price = price;
        this.hasMeals = hasMeals;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDesitinationCity() {
        return desitinationCity;
    }

    public void setDesitinationCity(String desitinationCity) {
        this.desitinationCity = desitinationCity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasMeals() {
        return hasMeals;
    }

    public void setHasMeals(boolean hasMeals) {
        this.hasMeals = hasMeals;
    }

    @Override
    public String toString() {
        return sourceCity + " to " + desitinationCity + " via " + airline + " for " + price;
    }
}
