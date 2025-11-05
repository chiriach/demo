package com.example.MallManagement.model;

public class StaffAssignment {
    private String id;
    private String floorId;
    private String staffId;
    private Shift shift;

    public enum Shift{
        Morning, Evening, Night
    };

    public StaffAssignment(String id, String floorId, String staffId, Shift shift) {
        this.id = id;
        this.floorId = floorId;
        this.staffId = staffId;
        this.shift = shift;

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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
