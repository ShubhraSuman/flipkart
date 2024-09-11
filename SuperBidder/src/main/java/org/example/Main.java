package org.example;

import org.example.model.SuperBidderSystem;

public class Main {
    public static void main(String[] args) {
        SuperBidderSystem system = new SuperBidderSystem();

        // Test case 1
        system.addBuyer("buyer1", 20);
        system.addBuyer("buyer2", 20);
        system.addBuyer("buyer3", 20);
        system.addSeller("seller1");

        system.createAuction("A1", 10, 50, "seller1", true);
        system.placeBid("buyer1", "A1", 17);
        system.placeBid("buyer2", "A1", 15);
        system.updateBid("buyer2", "A1", 19);
        system.placeBid("buyer3", "A1", 19);
        system.closeAuction("A1");

        // Test case 2
        system.addSeller("seller2");
        system.createAuction("A2", 5, 20, "seller2", true);
        system.placeBid("buyer3", "A2", 25); // Should fail
        system.placeBid("buyer2", "A2", 5);
        system.withdrawBid("buyer2", "A2");
    }
}