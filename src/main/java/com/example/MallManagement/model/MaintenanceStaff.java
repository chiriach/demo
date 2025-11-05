package com.example.MallManagement.model;
import java.awt.*;

public class MaintenanceStaff extends Staff implements Identifiable{

    private List assignments;
    private Type type;

    public enum Type{
        Electrical, Cleaning
    };


    public MaintenanceStaff(String id, String name, Type type, int salary) {
        super(id, name, salary);
        this.type = type;
        this.assignments = new List();

    }

    public List getAssignments() {
        return assignments;
    }

    public void setAssignments(List assignments) {
        this.assignments = assignments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
