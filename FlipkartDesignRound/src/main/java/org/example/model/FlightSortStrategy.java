package org.example.model;

import java.util.List;

public interface FlightSortStrategy {
    void sort(List<Flight> flights,boolean ascending);
}
