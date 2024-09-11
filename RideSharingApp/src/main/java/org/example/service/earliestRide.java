package org.example.service;

import org.example.model.Ride;

import java.util.Comparator;

public class earliestRide  implements Comparator<Ride> {
    @Override
    public int compare(Ride a, Ride b) {
        return a.getStartTime().compareTo(b.getStartTime());
    }
}
