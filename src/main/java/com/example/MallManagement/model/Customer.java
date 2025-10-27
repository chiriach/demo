package com.example.MallManagement.model;


import java.awt.*;

public class Customer {

    public String id, name, currency;
    public List purchases;

    Customer(String id, String name, String currency){
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.purchases = new List();
    }
}
