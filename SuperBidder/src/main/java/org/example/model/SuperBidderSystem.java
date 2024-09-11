package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class SuperBidderSystem {
    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;
    private Map<String, Auction> auctions;

    public SuperBidderSystem() {
        this.buyers = new HashMap<>();
        this.sellers = new HashMap<>();
        this.auctions = new HashMap<>();
    }

    public void addBuyer(String name, double budget) {
        buyers.put(name, new Buyer(name, budget));
        System.out.println("Buyer " + name + " added with budget " + budget);
    }

    public void addSeller(String name) {
        sellers.put(name, new Seller(name));
        System.out.println("Seller " + name + " added.");
    }

    public void createAuction(String auctionId, double minBid, double maxBid, String sellerName, boolean useHighestUniqueBid) {
        Seller seller = sellers.get(sellerName);
        if (seller == null) {
            System.out.println("Seller " + sellerName + " not found.");
            return;
        }

        Auction auction = new Auction(auctionId, minBid, maxBid, seller, useHighestUniqueBid);
        auctions.put(auctionId, auction);
        seller.addAuction(auction);
        System.out.println("Auction " + auctionId + " created by " + sellerName);
    }

    public void placeBid(String buyerName, String auctionId, double amount) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);

        if (buyer == null) {
            System.out.println("Buyer " + buyerName + " not found.");
            return;
        }
        if (auction == null) {
            System.out.println("Auction " + auctionId + " not found.");
            return;
        }

        auction.placeBid(buyer, amount);
    }

    public void updateBid(String buyerName, String auctionId, double amount) {
        placeBid(buyerName, auctionId, amount);
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);

        if (buyer == null) {
            System.out.println("Buyer " + buyerName + " not found.");
            return;
        }
        if (auction == null) {
            System.out.println("Auction " + auctionId + " not found.");
            return;
        }

        auction.withdrawBid(buyer);
    }

    public void closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            System.out.println("Auction " + auctionId + " not found.");
            return;
        }
        auction.closeAuction();
    }
}

