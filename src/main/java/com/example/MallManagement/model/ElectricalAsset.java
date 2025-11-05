package com.example.MallManagement.model;



public class ElectricalAsset {
    private String id;
    private String floorId;
    private Type type;
    private Status status;

    public enum Type{
        Lift, AC, Light, Escalator
    };
    public enum Status{
        Working, Down
    };

    public ElectricalAsset() {}

    public ElectricalAsset(String id, String floorId, Type type, Status status) {
        this.id = id;
        this.floorId = floorId;
        this.type = type;
        this.status = status;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFloorId() { return floorId; }
    public void setFloorId(String floorId) { this.floorId = floorId; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
