package org.example.model;

import java.util.List;

public class ArrivalTimeSortStrategy implements FlightSortStrategy{
    @Override
    public void sort(List<Flight> flights, boolean ascending) {
        flights.sort((f1,f2)-> ascending
                ? f1.getArrivalTime().compareTo(f2.getArrivalTime())
                : f2.getArrivalTime().compareTo(f1.getArrivalTime()));
    }
}