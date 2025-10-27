package com.example.MallManagement.model;

import java.awt.*;

public class Shop{

    public String id, name, ownerName;
    public double areaSqm;
    public List purchases;

    Shop(String id, String name,String ownerName, double areaSqm){
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this. areaSqm = areaSqm;
        this.purchases = new List();
    }
}
