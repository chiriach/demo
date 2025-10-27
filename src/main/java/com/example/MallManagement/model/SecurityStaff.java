package com.example.MallManagement.model;

public class SecurityStaff extends Staff {

    public String badgeNo;
    SecurityStaff(String id, String name, String badgeNo) {
        super(id, name);
        this.badgeNo = badgeNo;
    }
}
