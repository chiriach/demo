package com.example.MallManagement.model;

public class Purchase {

    private String id, customerId, shopId;
    private double amount;

    Purchase(String id, String customerId, String shopId, double amount){
        this.id = id;
        this.customerId = customerId;
        this.shopId = shopId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
