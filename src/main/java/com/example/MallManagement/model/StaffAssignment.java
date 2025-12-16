package com.example.MallManagement.model;

import jakarta.persistence.*;

@Entity
public class StaffAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public enum Shift { Morning, Evening, Night }

    public StaffAssignment() {}

    public StaffAssignment(Shift shift, Floor floor, Staff staff) {
        this.shift = shift;
        this.floor = floor;
        this.staff = staff;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Shift getShift() { return shift; }
    public void setShift(Shift shift) { this.shift = shift; }

    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }

    public Staff getStaff() { return staff; }
    public void setStaff(Staff staff) { this.staff = staff; }
}