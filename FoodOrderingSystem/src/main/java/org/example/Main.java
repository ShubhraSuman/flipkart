package org.example;

import org.example.model.Item;
import org.example.model.Order;
import org.example.service.OrderService;
import org.example.service.RestrauntService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RestrauntService restrauntService = new RestrauntService();

        List<Item> itemList = new ArrayList<>();

        Item item = new Item("king_burger", 10);
        Item item1 = new Item("samosa_pizza", 20);
        Item item2 = new Item("alu_pasta", 19);
        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);
        restrauntService.addRestraunt("resta1", itemList, 15);

        List<Item> itemList1 = new ArrayList<>();

        Item item4 = new Item("bendi_macaroni", 12);
        Item item5 = new Item("samosa_pizza", 25);
        Item item6 = new Item("alu_pasta", 17);
        itemList1.add(item4);
        itemList1.add(item5);
        itemList1.add(item6);
        restrauntService.addRestraunt("resta2", itemList1, 12);

        List<Item> itemList2 = new ArrayList<>();

        Item item7 = new Item("bendi_macaroni", 8);
        Item item8 = new Item("king_burger", 15);
        itemList2.add(item7);
        itemList2.add(item8);
        restrauntService.updateMenu("resta1", itemList2);

        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(new Item("bendi_macaroni",3));
        itemList3.add(new Item("samosa_pizza",2));
        Order order = new Order("order1","cust1",itemList3);
        OrderService orderService = new OrderService();
        System.out.println(orderService.bookOrder(order).getRestraName());
        System.out.println(orderService.bookOrder(order).getCapacityInUse());
    }
}