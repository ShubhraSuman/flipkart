package org.example.model;

import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private List<Item> itemList;

    public Order(String orderId, String customerName, List<Item> itemList) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.itemList = itemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
