package org.example.service;

import org.example.model.Ride;
import org.example.model.User;
import org.example.model.Vehicle;

import java.time.LocalDate;
import java.util.*;

public class RideService {
    public static HashMap<User, List<Ride>> allRidesTaken = new HashMap<User, List<Ride>>();
    //contains all rides
    public static List<Ride> allOffers = new ArrayList<Ride>();

    public static Ride offerRide(String name, String RegNo, int seats, String origin, String destination, LocalDate startTime, int duration, int numberOfSeats) {
        User u = UserService.getUserByNameandRegNo(name,RegNo);
        Vehicle v = UserService.getVehicleByRegNo(RegNo);
        Ride r = new Ride(origin,destination,v,startTime,numberOfSeats);
        allOffers.add(r);
        u.setRideOffered(u.getRideOffered()+1);
        return r;
    }

    private static Ride selectRideService(User u, String origin, String destination, String type){
        List<Ride> specificRides= getAllAvailableRidesWithSourceAndDestinationForUser(u,origin,destination);
        if(specificRides.isEmpty())
            return null;

        switch(type) {

            case "Fastest_Ride":{
                Collections.sort(specificRides, new fastestRide());
                return specificRides.get(0);
            }

            case "Earliest_Ride":{
                Collections.sort(specificRides,new earliestRide());
                return specificRides.get(0);
            }

            default:
                return null;


        }
    }

    private static List<Ride> getAllAvailableRidesWithSourceAndDestinationForUser(User u, String origin, String destination) {
        List<Ride> availableRideWithSrcAndDest = new ArrayList<>();

        for(Ride ride: allOffers){
            if(ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getNumberOfSeatsAvailable()!=0){
                availableRideWithSrcAndDest.add(ride);
            }
        }
        return availableRideWithSrcAndDest;
    }

    public static Ride selectRide(String name,String origin,String destination,String type) {
        User u = UserService.getUserByName(name);

        if(u ==null){
            System.out.println("No such user is there "+ name);
            return null;
        }

        Ride r = selectRideService(u,origin,destination,type);

        if (r== null) {
            System.out.println("No such ride is there with origin " + origin+ " Destination " +destination+" and type "+type);
            return null;
        }

        //change the state of ride offerer
        r.setNumberOfSeatsAvailable(r.getNumberOfSeatsAvailable()-1);

        //change the state of ride taker
        u.setRidetaken(u.getRidetaken()+1);

        //map the user with which ride it takes
        if(allRidesTaken.containsKey(u)) {
            List<Ride> rideByUser = allRidesTaken.get(u);
            rideByUser.add(r);

        }else {
            List<Ride> rideByUser =new ArrayList<Ride>();
            rideByUser.add(r);
            allRidesTaken.put(u,rideByUser);
        }

        System.out.println("Ride is given by "+r.getRideGiver().getName()+" With Vehicle "+ r.getVehicle().getRegNo()+" to "+u.getName());

        return r;
    }

}
