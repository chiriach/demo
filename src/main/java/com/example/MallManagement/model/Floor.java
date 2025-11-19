package com.example.MallManagement.model;

import java.util.*;
public class Floor implements Identifiable{
    private String id;
    private int number;
    private List<Shop> shops;
    private List<MaintenanceTask> tasks;
    private List<ElectricalAsset> electricals;
    private List<StaffAssignment> assignments;

    public Floor(){}

    public Floor(String id, int number) {
        this.id = id;
        this.number = number;
        this.shops = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.electricals = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<MaintenanceTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<MaintenanceTask> tasks) {
        this.tasks = tasks;
    }

    public List<ElectricalAsset> getElectricals() {
        return electricals;
    }

    public void setElectricals(List<ElectricalAsset> electricals) {
        this.electricals = electricals;
    }

    public List<StaffAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<StaffAssignment> assignments) {
        this.assignments = assignments;
    }
}
