package com.example.MallManagement.model;

public class Purchase {

    public String id, customerId, shopId;
    public double amount;

    Purchase(String id, String customerId, String shopId, double amount){
        this.id = id;
        this.customerId = customerId;
        this.shopId = shopId;
        this.amount = amount;
    }
}
