package org.example.model;

import java.util.Map;

public class Buyer {
    private String name;
    private double budget;
    private Map<String, Double> bids;

    public Buyer(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public boolean canBid(double amount) {
        return budget >= amount;
    }

    public void addBid(String auctionNumber, double bidAmount) {
        if (canBid(bidAmount))
            bids.put(auctionNumber, bidAmount);
        else
            System.out.println("Bid amount exceeds budget.");
    }

    public void updateBid(String auctionNumber, double bidAmount) {
        if (canBid(bidAmount))
            bids.put(auctionNumber, bidAmount);
        else
            System.out.println("Bid amount exceeds budget.");
    }

    public void withDrawBid(String auctionNumber) {
        bids.remove(auctionNumber);
    }

    public void increaseBudget(double amount) {
        this.budget += amount;
    }

    public void decreaseBudget(double amount) {
        this.budget -= amount;
    }

    public Double getBidForAuction(String auctionNumber) {
        return bids.get(auctionNumber);
    }

}
