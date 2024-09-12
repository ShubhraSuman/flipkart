package org.example;

import org.example.model.ArrivalTimeSortStrategy;
import org.example.model.DepartureTimeSortStrategy;
import org.example.model.FlightSortStrategy;
import org.example.model.Route;
import org.example.service.FlightService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        FlightSortStrategy departureTimeStrategy = new DepartureTimeSortStrategy();
        FlightSortStrategy arrivalTimeStrategy = new ArrivalTimeSortStrategy();
        // Register flights
        flightService.registerFlight("JetAir","DEL","BLR",500,false);
        flightService.registerFlight("JetAir","BLR","LON",1000,false);
        flightService.registerFlight("Delta","DEL","LON",2000,false);
        flightService.registerFlight("Delta","LON","NYC",2000,false);
        flightService.registerFlight("Indigo","LON","NYC",2500,true);
        flightService.registerFlight("Indigo","DEL","BLR",600,true);
        flightService.registerFlight("Indigo","BLR","PAR",800,true);
        flightService.registerFlight("Indigo","PAR","LON",300,true);
        System.out.println();

        System.out.println("Search for flight from DEL to NYC");
        //Min hops
        Route minHops = flightService.findMinHopsRoute("DEL","NYC",false);
        System.out.println("Route with Minimum Hops: ");
        System.out.println(minHops);

        //Cheapest
        Route cheapest = flightService.findCheapestRoute("DEL","NYC",false);
        System.out.println("Route with cheapest cost: ");
        System.out.println(cheapest);


        //Filter with meals
        System.out.println("Search for flight from DEL to NYC with meals");
        Route minHopsRoute = flightService.findMinHopsRoute("DEL","NYC",true);
        System.out.println("Route with Minimum Hops: ");
        System.out.println(minHopsRoute);

        Route cheapestRoute = flightService.findMinHopsRoute("DEL","NYC",true);
        System.out.println("Route with cheapest cost: ");
        System.out.println(cheapestRoute);




        // Registering flights with departure and arrival times
        flightService.registerFlight("JetAir", "DEL", "BLR", 500, true,
                LocalDateTime.of(2024, 9, 15, 10, 0),
                LocalDateTime.of(2024, 9, 15, 12, 0));
        flightService.registerFlight("Delta", "BLR", "NYC", 2000, true,
                LocalDateTime.of(2024, 9, 15, 14, 0),
                LocalDateTime.of(2024, 9, 15, 20, 0));

        // Search and sort by departure time
        Route route = flightService.searchAndSortRoute("DEL", "NYC", new DepartureTimeSortStrategy(), true, true);
        System.out.println(route.getFlights());

        // Search and sort by arrival time
        route = flightService.searchAndSortRoute("DEL", "NYC", new ArrivalTimeSortStrategy(), false, true);
        System.out.println(route.getFlights());
//        System.out.println(" Seaching for cheapest route ");
//        Route cheapestRouteWithMeals = flightService.searchAndSortRoute("DEL","NYC",arrivalTimeStrategy,true,true);
//        System.out.println(cheapestRouteWithMeals);
    }
}