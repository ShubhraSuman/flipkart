package org.example.service;

import org.example.model.Item;
import org.example.model.Restraunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestrauntService {
    private static Map<Restraunt, List<Item>> allRestrauntWithMenu = new HashMap<>();

    public static void addRestraunt(String restrauntName, List<Item> items, int maxProcessingCapacity) {
        Restraunt restraunt = getRestrauntByRestrauntName(restrauntName);
        if(restraunt == null)
        {
            restraunt = new Restraunt(maxProcessingCapacity, restrauntName, items);
        }
        restraunt.setCapacityInUse(maxProcessingCapacity);
        allRestrauntWithMenu.put(restraunt, items);
        System.out.println("Restraunt cretated with deatils: ");
        restraunt.printRestrauntDetails();
    }

    public void updateMenu(String restrauntName, List<Item> newItemList) {
        Restraunt restraunt = getRestrauntByRestrauntName(restrauntName);
        List<Item> oldItems = restraunt.getItemList();
        Map<String,Item> mp = new HashMap<>();
        List<Item> updatedItems = new ArrayList<>();
        for(Item item : newItemList){
            mp.put(item.getItemName(),item);
        }

        for(Item item: oldItems){
            if(mp.containsKey(item.getItemName())){
                updatedItems.add(mp.get(item.getItemName()));
            }
            else{
                updatedItems.add(item);
            }
        }

        for (Map.Entry<String, Item> mapEntry : mp.entrySet()) {
            String itemName = mapEntry.getKey();

            // Check if updatedItems already contains an item with this name
            boolean alreadyExists = false;
            for (Item updatedItem : updatedItems) {
                if (updatedItem.getItemName().equals(itemName)) {
                    alreadyExists = true;
                    break;
                }
            }

            // If the item doesn't exist, add it to updatedItems
            if (!alreadyExists) {
                updatedItems.add(mapEntry.getValue());
            }
        }

        restraunt.setItemList(updatedItems);
        allRestrauntWithMenu.put(restraunt, updatedItems);
        System.out.println("Restraunt updated with menu details: ");
        restraunt.printRestrauntDetails();
    }

    private List<Item> getItemsByRestrauntName(String restrauntName) {
        for (Map.Entry<Restraunt, List<Item>> mp : allRestrauntWithMenu.entrySet()) {
            if (mp.getKey().getRestraName().equals(restrauntName)) {
                return mp.getValue();
            }
        }
        return null;
    }

    private static Restraunt getRestrauntByRestrauntName(String restrauntName) {
        for (Map.Entry<Restraunt, List<Item>> mp : allRestrauntWithMenu.entrySet()) {
            if (mp.getKey().getRestraName().equals(restrauntName)) {
                return mp.getKey();
            }
        }
        return null;
    }

    public static Map<Restraunt, List<Item>> getAllRestrauntWithMenu(){
        return allRestrauntWithMenu;
    }
}
