package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Flight> flights;
    private double totalCost;

    public Route() {
        this.flights = new ArrayList<>();
        this.totalCost = 0;
    }

    public Route(List<Flight> flights, double totalCost, int totalHops) {
        this.flights = flights;
        this.totalCost = totalCost;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlights(Flight flight) {
        flights.add(flight);
        totalCost += flight.getPrice();
    }

    public double getTotalCost() {
        return flights.stream().mapToDouble(Flight::getPrice).sum();
    }

    public int getTotalHops() {
        return flights.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Flight flight : flights) {
            sb.append(flight.toString()).append("\n");
        }
        sb.append("Total flights= ").append(getTotalHops()).append("\n");
        sb.append("Total cost = ").append(getTotalCost()).append("\n");
        return sb.toString();
    }
}
