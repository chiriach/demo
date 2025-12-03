package com.example.MallManagement.model;

import jakarta.persistence.*;

@Entity
public class ElectricalAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    public enum Type { Lift, AC, Light, Escalator }
    public enum Status { Working, Down }

    public ElectricalAsset() {}

    public ElectricalAsset(Type type, Status status, Floor floor) {
        this.type = type;
        this.status = status;
        this.floor = floor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }
}