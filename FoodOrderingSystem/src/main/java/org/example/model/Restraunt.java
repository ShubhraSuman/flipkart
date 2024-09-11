package org.example.model;

import java.util.List;
import java.util.Map;

public class Restraunt {
    private int maxProcessingCapacity;
    private String restraName;
    private List<Item> itemList;
    private int capacityInUse;

    public Restraunt(int maxProcessingCapacity, String restraName, List<Item> itemList) {
        this.maxProcessingCapacity = maxProcessingCapacity;
        this.restraName = restraName;
        this.itemList = itemList;
        this.capacityInUse = 0;
    }

    public int getCapacityInUse() {
        return capacityInUse;
    }

    public void setCapacityInUse(int capacityInUse) {
        this.capacityInUse = capacityInUse;
    }

    public int getMaxProcessingCapacity() {
        return maxProcessingCapacity;
    }

    public void setMaxProcessingCapacity(int maxProcessingCapacity) {
        this.maxProcessingCapacity = maxProcessingCapacity;
    }

    public String getRestraName() {
        return restraName;
    }

    public void setRestraName(String restraName) {
        this.restraName = restraName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void printRestrauntDetails() {
        System.out.print("Restraunt{" +
                "maxProcessingCapacity=" + maxProcessingCapacity +
                ", restraName='" + restraName + '\'');
        System.out.print("{");
        for (Item items : itemList) {
            System.out.print(items.getItemName() + " : " + items.getItemQuantity() + ",");
        }
        System.out.print("}");
        System.out.println();
    }
}
