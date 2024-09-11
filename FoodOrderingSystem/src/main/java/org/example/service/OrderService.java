package org.example.service;

import org.example.model.Item;
import org.example.model.Order;
import org.example.model.Restraunt;

import java.util.List;
import java.util.Map;

public class OrderService {
//    private Map<>

    public Restraunt bookOrder(Order order){
        Map<Restraunt, List<Item>> allRestrauntWithMenu = RestrauntService.getAllRestrauntWithMenu();
        List<Item> itemList = order.getItemList();

        for(Map.Entry<Restraunt,List<Item>> mp : allRestrauntWithMenu.entrySet()){
            List<Item> rsItem = mp.getValue();
            int s = 0;
            int capMinus = 0;

            for(Item item : rsItem){
                for(Item item1: itemList){
                    if(item1.getItemName().equals(item.getItemName()) && item.getItemQuantity() >= item1.getItemQuantity()){
                        s++;
                    }
                }
            }

            if(s == itemList.size()){
                for(Item item : itemList){
                    capMinus += item.getItemQuantity();
                }
                mp.getKey().setCapacityInUse(capMinus);
                mp.getKey().setMaxProcessingCapacity(mp.getKey().getMaxProcessingCapacity()-capMinus);
                return mp.getKey();
            }
        }
        return null;
    }
}
