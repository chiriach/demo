package com.example.MallManagement.model;

public class ElectricalAsset{
    private String id;
    private String floorId;
    private String type;
    private String status;

    public ElectricalAsset(String id, String floorId, String type, String status) {
        this.id = id;
        this.floorId = floorId;
        this.type = type;
        this.status = status;

        if (!this.type.equals("Lift") && !this.type.equals("AC") && !this.type.equals("Light") && !this.type.equals("Escalator")) {
            throw new IllegalArgumentException();
        }

        if (!this.status.equals("Working") && !this.status.equals("Down") ) {
            throw new IllegalArgumentException();
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
