package org.example.service;

import org.example.model.User;
import org.example.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> userList;
    public static List<Vehicle> allVehicle = new ArrayList<Vehicle>();

    public static User createUser(String name, int age, char gender) {
        User user = new User(name, gender, age);
        userList.add(user);
        System.out.println("Created user having details: " + user.toString());
        return user;
    }

    public static Vehicle addVehicle(User u, String owner, String model, String regNo) {
        Vehicle v = new Vehicle(owner,model,regNo);
        allVehicle.add(v);
        u.addVehicle(v);
        return v;
    }

    public static Vehicle addVehicle(String owner, String model, String regNo){
        User u = getUserByName(owner);
        if(u == null)
            return null;
        Vehicle v = new Vehicle(owner,model,regNo);
        u.addVehicle(v);
        allVehicle.add(v);
        return v;
    }

    public static User getUserByName(String name){
        for(User u : userList){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }

    public static Vehicle getVehicleByRegNo(String RegNo) {
        for(Vehicle v:allVehicle) {
            if(v.getRegNo().equals(RegNo)) {
                return v;
            }
        }
        return null;
    }

    public static User getUserByNameandRegNo(String name,String RegNo) {
        Vehicle v =  getVehicleByRegNo(RegNo);
        if (v==null) {
            return null;
        }
        for(User u:userList) {
            if(u.getName().equals(name) && u.getVehicles().contains(v)) {
                return u;
            }
        }
        return null;
    }

}
