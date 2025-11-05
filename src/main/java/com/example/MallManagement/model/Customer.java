package com.example.MallManagement.model;
import java.awt.*;

public class Customer {

    private String id, name, currency;
    private List purchases;

    public Customer(String id, String name, String currency){
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.purchases = new List();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getPurchases() {
        return purchases;
    }

    public void setPurchases(List purchases) {
        this.purchases = purchases;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
