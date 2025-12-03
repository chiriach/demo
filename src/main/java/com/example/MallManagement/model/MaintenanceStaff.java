package com.example.MallManagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("MAINTENANCE")
public class MaintenanceStaff extends Staff {

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        Electrical, Cleaning
    }

    public MaintenanceStaff() {}

    public MaintenanceStaff(String name, Type type, int salary) {
        super(name, salary);
        this.type = type;
    }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
}