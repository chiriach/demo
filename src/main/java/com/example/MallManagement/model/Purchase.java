package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Betrag muss positiv sein")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Purchase() {}

    public Purchase(double amount, Customer customer, Shop shop) {
        this.amount = amount;
        this.customer = customer;
        this.shop = shop;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
}