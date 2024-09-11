package org.example;

import org.example.model.Ride;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.service.RideService;
import org.example.service.UserService;

public class Main {

    public static void main(String[] args) throws Exception {

        //add driverService to take input from system and loop in while till exit and user switch for cases ...generally not required in machine coding round
        //one can hard code like this

        //create rohan
        User u1 = UserService.createUser("Rohan", 36, 'M');

        //if single Rohan is there
        //vehicle v1 =userService.addVehicle("Rohan","Swift","KA-01-12345");

        //if multiple Rohans are there
        Vehicle v1 =UserService.addVehicle(u1,"Rohan","Swift","KA-01-12345");



        //create shashank
        User u2 =UserService.createUser("Shashank", 29, 'M');
        Vehicle v2 = UserService.addVehicle(u2,"Shashank", "Baleno", "TS-05-62395");

        //create nandani
        User u3 =UserService.createUser("Nandani", 29, 'F');


        //create user Shipra
        User u4 =UserService.createUser("Shipra", 27, 'F');
        Vehicle v41 = UserService.addVehicle(u4,"Shipra", "Polo", "KA-05-41491");
        Vehicle v42 = UserService.addVehicle(u4,"Shipra", "Scooty", "KA-12-12332");

        //create user gaurav
        User u5 =UserService.createUser("Gaurav", 29, 'M');



        //offer ride Rohan
        Ride r1 = RideService.offerRide("Rohan", "KA-01-12345", 1, "Hyderabad", "Bangalore", "25 Jan, 2019 08",13);

        //offer ride Shipra
        Ride r2 = RideService.offerRide("Shipra", "KA-12-12332", 1, "Bangalore", "Mysore", "29 Jan, 2019 18",10);

        //offer ride Shipra
        Ride r3 = RideService.offerRide("Shipra","KA-05-41491", 2, "Bangalore", "Mysore", "30 Jan, 2019 18",4);

        //offer ride Shashank
        Ride r4 = RideService.offerRide("Shashank", "TS-05-62395", 2, "Hyderabad", "Bangalore", "27 Jan, 2019 10",14);



        //select ride nandani
        Ride rs1 = RideService.selectRide("Nandani", "Bangalore", "Mysore", "Fastest_Ride");

        //select ride gaurav
        Ride rs2 = RideService.selectRide("Gaurav", "Bangalore", "Mysore", "Earliest_Ride");

        //select ride shashank
        Ride rs3 = RideService.selectRide("Shashank", "Mumbai", "Bangalore", "Fastest_Ride");

        //select ride Rohan
        Ride rs4= RideService.selectRide("Rohan", "Hyderabad", "Bangalore", "Fastest_Ride");


        System.out.println();
        //getTotalFuelSavedByUsers
//        rideService.fuelSavedByUser();


        System.out.println();

        //Find Total Rides by user
//        rideService.totalRidesByUser();



    }

}