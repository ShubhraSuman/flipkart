package org.example.service;

import org.example.model.Flight;
import org.example.model.FlightSortStrategy;
import org.example.model.Route;

import java.time.LocalDateTime;
import java.util.*;

public class FlightService {
    private Map<String, List<Flight>> flightMap = new HashMap<>();

    public void registerFlight(String airline, String sourceCity, String destinationCity, double price, boolean hasMeals) {
        Flight flight = new Flight(airline, sourceCity, destinationCity, price, hasMeals);
        if (!flightMap.containsKey(sourceCity)) {
            flightMap.put(sourceCity, new ArrayList<>());
        }
        flightMap.get(sourceCity).add(flight);
        System.out.println(airline + " " + sourceCity + " -> " + destinationCity + " flight registered ");
    }

    //search for min hops
    public Route findMinHopsRoute(String sourceCity, String destinationCity, boolean mealRequired) {
        return searchRoute(sourceCity, destinationCity, true, mealRequired);
    }

    public Route findCheapestRoute(String sourceCity, String destinationCity, boolean mealRequired) {
        return searchRoute(sourceCity, destinationCity, false, mealRequired);
    }

    private Route searchRoute(String sourceCity, String destinationCity, boolean byHops, boolean mealRequired) {
        PriorityQueue<Route> queue = new PriorityQueue<>((r1, r2) -> {
            if (byHops) {
                if (r1.getTotalHops() != r2.getTotalHops()) {
                    return Integer.compare(r1.getTotalHops(), r2.getTotalHops());
                }
                return Double.compare(r1.getTotalCost(), r2.getTotalCost());
            } else {
                if (Double.compare(r1.getTotalCost(), r2.getTotalCost()) != 0) {
                    return Double.compare(r1.getTotalCost(), r2.getTotalCost());
                }
                return Integer.compare(r1.getTotalHops(), r2.getTotalHops());
            }
        });
        Route initalRoute = new Route();
        queue.add(initalRoute);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Route currentRoute = queue.poll();
            String currentCity = currentRoute.getFlights().isEmpty() ? sourceCity : currentRoute.getFlights().get(currentRoute.getFlights().size() - 1).getDesitinationCity();

            if (currentCity.equals(destinationCity)) {
                return currentRoute;
            }

            if (visited.contains(currentCity)) continue;

            visited.add(currentCity);

            List<Flight> availableFlights = flightMap.getOrDefault(currentCity, new ArrayList<>());

            for (Flight flight : availableFlights) {
                if (mealRequired && !flight.isHasMeals())
                    continue;
                Route newRoute = new Route();
                newRoute.getFlights().addAll(currentRoute.getFlights());
                newRoute.addFlights(flight);
                queue.add(newRoute);
            }
        }
        return null;
    }

    public Route searchAndSortRoute(String sourceCity, String destinationCity, FlightSortStrategy flightSortStrategy, boolean ascending, boolean mealsRequired){
        Route route = searchRoute(sourceCity,destinationCity,false,mealsRequired);
        if(route!= null){
            List<Flight> flights = route.getFlights();
            flightSortStrategy.sort(flights,ascending);
        }
        return route;
    }

    public void registerFlight(String airline, String sourceCity, String destinationCity, double price, boolean hasMeals, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        Flight flight = new Flight(airline, sourceCity, destinationCity, price, hasMeals,departureTime,arrivalTime);
        if (!flightMap.containsKey(sourceCity)) {
            flightMap.put(sourceCity, new ArrayList<>());
        }
        flightMap.get(sourceCity).add(flight);
        System.out.println(airline + " " + sourceCity + " -> " + destinationCity + " flight registered ");
    }

}
