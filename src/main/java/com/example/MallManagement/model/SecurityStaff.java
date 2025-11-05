package com.example.MallManagement.model;

public class SecurityStaff extends Staff implements Identifiable{

    private String badgeNo;

    public SecurityStaff(String id, String name, String badgeNo, int salary) {
        super(id, name, salary);
        this.badgeNo = badgeNo;
    }

    public String getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(String badgeNo) {
        this.badgeNo = badgeNo;
    }


}
