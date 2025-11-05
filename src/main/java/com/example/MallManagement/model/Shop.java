package com.example.MallManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String id;
    private String name;
    private String ownerName;
    private double areaSqm;
    private int rating;
    private List<String> purchases = new ArrayList<>();

    // ✅ Required for Spring form binding
    public Shop() {}

    public Shop(String id, String name, String ownerName, double areaSqm, int rating) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.areaSqm = areaSqm;
        this.rating = rating;
    }

    // Getters and setters for all fields
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public double getAreaSqm() { return areaSqm; }
    public void setAreaSqm(double areaSqm) { this.areaSqm = areaSqm; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public List<String> getPurchases() { return purchases; }
    public void setPurchases(List<String> purchases) { this.purchases = purchases; }
}
