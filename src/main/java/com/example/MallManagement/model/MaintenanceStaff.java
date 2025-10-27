package com.example.MallManagement.model;


import java.awt.*;

public class MaintenanceStaff extends Staff{

    public List assignments;
    public String type;

    MaintenanceStaff(String id, String name, String type) {
        super(id, name);
        this.assignments = new List();
        if(!this.type.equals("Electrical") && !this.type.equals("Cleaning")) throw new IllegalArgumentException();
    }

}
