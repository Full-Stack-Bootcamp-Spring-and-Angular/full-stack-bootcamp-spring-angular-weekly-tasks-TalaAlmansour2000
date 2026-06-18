package com.myApp.service;

import com.myApp.entity.OrderIteams;
import com.myApp.entity.Orders;

import java.util.ArrayList;

public class OrderService {
    public void addOrderItem(Orders order , OrderIteams item) {
        if (order.getOrderIteams() == null) {
            order.setOrderIteams(new ArrayList<>());
        }
        order.getOrderIteams().add(item);
        item.setOrder(order);
        double priceOfItem = item.getProduct().getPrice() * item.getQuantity();
        order.setTotalPrice( priceOfItem+order.getTotalPrice());
        int currentStock = item.getProduct().getStockQuantity();
        item.getProduct().setStockQuantity(currentStock - item.getQuantity());
    }
}
