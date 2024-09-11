package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private String name;
    private List<Auction> auctions;

    public Seller(String name) {
        this.name = name;
        this.auctions = new ArrayList<>();
    }

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }
}
