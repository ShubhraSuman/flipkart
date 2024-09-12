package org.example.model;

import java.util.List;

public class DepartureTimeSortStrategy implements FlightSortStrategy{
    @Override
    public void sort(List<Flight> flights, boolean ascending) {
        flights.sort((f1,f2)-> ascending
        ? f1.getDepartureTime().compareTo(f2.getDepartureTime())
        : f2.getDepartureTime().compareTo(f1.getDepartureTime()));
    }
}
