package com.example.MallManagement.model;

public class MaintenanceStaff extends Staff implements Identifiable{

    private Type type;

    public enum Type{
        Electrical, Cleaning
    };

    public MaintenanceStaff(){}

    public MaintenanceStaff(String id, String name, Type type, int salary) {
        super(id, name, salary);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
