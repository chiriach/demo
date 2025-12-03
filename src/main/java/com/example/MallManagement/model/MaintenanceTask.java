package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MaintenanceTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description required")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private MaintenanceStaff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    public enum Status { Planned, Active, Done }

    public MaintenanceTask() {}

    public MaintenanceTask(String description, Status status, MaintenanceStaff staff, Floor floor) {
        this.description = description;
        this.status = status;
        this.staff = staff;
        this.floor = floor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public MaintenanceStaff getStaff() { return staff; }
    public void setStaff(MaintenanceStaff staff) { this.staff = staff; }
    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }
}