package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name ist erforderlich")
    private String name;

    @NotBlank(message = "Besitzername ist erforderlich")
    private String ownerName;

    @Positive(message = "Fläche muss positiv sein")
    private double areaSqm;

    @Min(value = 1, message = "Bewertung min. 1")
    @Max(value = 5, message = "Bewertung max. 5")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();

    public Shop() {}

    public Shop(String name, String ownerName, double areaSqm, int rating, Floor floor) {
        this.name = name;
        this.ownerName = ownerName;
        this.areaSqm = areaSqm;
        this.rating = rating;
        this.floor = floor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public double getAreaSqm() { return areaSqm; }
    public void setAreaSqm(double areaSqm) { this.areaSqm = areaSqm; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }

    public List<Purchase> getPurchases() { return purchases; }
    public void setPurchases(List<Purchase> purchases) { this.purchases = purchases; }
}