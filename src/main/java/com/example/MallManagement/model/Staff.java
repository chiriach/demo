package com.example.MallManagement.model;

import java.util.*;


public abstract class Staff implements Identifiable{

    private String id, name;
    private int salary;
    private List<StaffAssignment> assignments;

    Staff(String id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.assignments = new ArrayList<>();
    }

    public List<StaffAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<StaffAssignment> assignments) {
        this.assignments = assignments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
