package com.example.MallManagement.model;

import java.awt.*;

public class Shop{

    private String id, name, ownerName;
    private double areaSqm;
    private List purchases;

    Shop(String id, String name,String ownerName, double areaSqm){
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this. areaSqm = areaSqm;
        this.purchases = new List();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAreaSqm() {
        return areaSqm;
    }

    public void setAreaSqm(double areaSqm) {
        this.areaSqm = areaSqm;
    }

    public List getPurchases() {
        return purchases;
    }

    public void setPurchases(List purchases) {
        this.purchases = purchases;
    }
}
