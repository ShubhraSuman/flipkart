Buyer

Attributes: name, budget, bids
Methods: add_bid(), update_bid(), withdraw_bid(), increase_budget()
Seller

Attributes: name, auctions
Auction

Attributes: auction_id, min_bid, max_bid, bids, seller, status, winner, winning_bid, use_highest_unique_bid
Methods: add_bid(), update_bid(), withdraw_bid(), close_auction()
Bid

Attributes: buyer, amount
SuperBidderSystem

Methods: add_buyer(), add_seller(), create_auction(), create_bid(), update_bid(), withdraw_bid(), close_auction()
Here’s th