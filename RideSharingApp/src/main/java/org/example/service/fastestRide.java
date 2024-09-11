package org.example.service;

import org.example.model.Ride;

import java.util.Comparator;

public class fastestRide implements Comparator<Ride> {
    @Override
    public int compare(Ride o1, Ride o2) {
        return o1.getRide_duration()-o2.getRide_duration();
    }
}
