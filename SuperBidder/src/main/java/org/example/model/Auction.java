package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Auction {
    private String auctionNumber;
    private double lowestBid;
    private double highestBid;
    private Seller seller;
    private Map<Buyer, Double> bids;
    private boolean isClosed;
    private boolean useHighestUniqueBid;
    private Buyer winner;

    public Auction(String auctionNumber, double lowestBid, double highestBid, Seller seller, boolean useHighestUniqueBid) {
        this.auctionNumber = auctionNumber;
        this.lowestBid = lowestBid;
        this.highestBid = highestBid;
        this.seller = seller;
        this.bids = new HashMap<>();
        this.isClosed = false;
        this.useHighestUniqueBid = useHighestUniqueBid;
    }

    public String getAuctionNumber() {
        return this.auctionNumber;
    }

    public void placeBid(Buyer buyer, double amount) {
        if (isClosed)
            System.out.println("Auction is closed");
        if (amount < lowestBid || amount > highestBid)
            System.out.println("Bid out of bounds. Must be between");
        else {
            if (buyer.canBid(amount)) {
                bids.put(buyer, amount);
                System.out.println(buyer.getName() + " placed a bid of " + amount + " on " + auctionNumber);
            } else {
                System.out.println(buyer.getName() + " does not have enough budget.");
            }
        }
    }

    public void updateBid(Buyer buyer, double amount) {
        placeBid(buyer, amount);
    }

    public void withdrawBid(Buyer buyer) {
        if (bids.containsKey(buyer)) {
            bids.remove(buyer);
            System.out.println(buyer.getName() + " withdrew their bid from " + auctionNumber);
        } else {
            System.out.println(buyer.getName() + " has no bid to withdraw.");
        }
    }

    public void closeAuction() {
        isClosed = true;
        if (bids.isEmpty()) {
            System.out.println("No bids places for this auction");
            return;
        }
        winner = useHighestUniqueBid ? calculateHighestUniqueBidWinner() : calculateLowestUniqueBidWinner();
        if (winner != null) {
            System.out.println("Winner of auction " + auctionNumber + " is " + winner.getName() + " with a bid of " + bids.get(winner));
            winner.decreaseBudget(bids.get(winner));
        } else {
            System.out.println("No unique bid winner for auction " + auctionNumber);
        }
    }

    private Buyer calculateLowestUniqueBidWinner() {
        Map<Double, Integer> bidCounts = new HashMap<>();
        double lowestBid = Integer.MAX_VALUE;
        Buyer buyer = null;

        for (Double bid : bids.values()) {
            bidCounts.put(bid, bidCounts.getOrDefault(bid, 0) + 1);
        }

        for (Map.Entry<Buyer, Double> mp : bids.entrySet()) {
            if (mp.getValue() < lowestBid && bidCounts.get(mp.getValue()) == 1) {
                buyer = mp.getKey();
                lowestBid = mp.getValue();
            }
        }
        return buyer;

    }

    private Buyer calculateHighestUniqueBidWinner() {
        Map<Double, Integer> bidCounts = new HashMap<>();
        double highestBid = Integer.MIN_VALUE;
        Buyer buyer = null;

        for (Double bid : bids.values()) {
            bidCounts.put(bid, bidCounts.getOrDefault(bid, 0) + 1);
        }

        for (Map.Entry<Buyer, Double> mp : bids.entrySet()) {
            if (mp.getValue() > highestBid && bidCounts.get(mp.getValue()) == 1) {
                buyer = mp.getKey();
                highestBid = mp.getValue();
            }
        }
        return buyer;
    }
}

