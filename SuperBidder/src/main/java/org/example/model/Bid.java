package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bid {
    private String buyerName;
    private String auctionNumber;
    private int bidAmount;
    Map<String, List<Bid>> mapBidPerAuction = new HashMap<>();

    public Bid(String buyerName, String auctionNumber, int bidAmount) {
        this.buyerName = buyerName;
        this.auctionNumber = auctionNumber;
        this.bidAmount = bidAmount;
    }

    public void addBidToMap(Bid bid){
        if (mapBidPerAuction.containsKey(bid.auctionNumber)) {
            mapBidPerAuction.get(bid.auctionNumber).add(bid);
        }
        else{
            mapBidPerAuction.put(bid.auctionNumber,new ArrayList<>());
            mapBidPerAuction.get(bid.auctionNumber).add(bid);
        }
    }

    public List<Bid> getBidsPerAuction(String auctionNumber) {
        if (mapBidPerAuction.containsKey(auctionNumber)) {
            return mapBidPerAuction.get(auctionNumber);
        }
        return new ArrayList<>();
    }
}
