package com.example.MallManagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("SECURITY")
public class SecurityStaff extends Staff {

    @NotBlank(message = "Badge Nummer ist erforderlich")
    private String badgeNo;

    public SecurityStaff() {}

    public SecurityStaff(String name, String badgeNo, int salary) {
        super(name, salary);
        this.badgeNo = badgeNo;
    }

    public String getBadgeNo() { return badgeNo; }
    public void setBadgeNo(String badgeNo) { this.badgeNo = badgeNo; }
}