package com.example.MallManagement.model;
import java.awt.*;

public class MaintenanceStaff extends Staff{

    private List assignments;
    private String type;

    MaintenanceStaff(String id, String name, String type, int salary) {
        super(id, name, salary);
        this.type = type;
        this.assignments = new List();
        if(!this.type.equals("Electrical") && !this.type.equals("Cleaning")) throw new IllegalArgumentException();
    }

    public List getAssignments() {
        return assignments;
    }

    public void setAssignments(List assignments) {
        this.assignments = assignments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
