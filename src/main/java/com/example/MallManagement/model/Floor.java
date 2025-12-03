package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nummer ist erforderlich")
    @Min(value = 0, message = "Etage darf nicht negativ sein")
    private Integer number;

    // Relationship: Many floors belong to one Mall
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mall_id")
    private Mall mall;

    // Relationship: A floor has many shops
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop> shops = new ArrayList<>();

    // Relationship: A floor has many electrical assets
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElectricalAsset> electricals = new ArrayList<>();

    // Relationship: A floor has many staff assignments
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StaffAssignment> assignments = new ArrayList<>();

    // Relationship: A floor has many maintenance tasks
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceTask> tasks = new ArrayList<>();

    public Floor() {}

    // This is the constructor DataInitializer is looking for
    public Floor(Integer number, Mall mall) {
        this.number = number;
        this.mall = mall;
    }

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Mall getMall() { return mall; }
    public void setMall(Mall mall) { this.mall = mall; }

    public List<Shop> getShops() { return shops; }
    public void setShops(List<Shop> shops) { this.shops = shops; }

    public List<ElectricalAsset> getElectricals() { return electricals; }
    public void setElectricals(List<ElectricalAsset> electricals) { this.electricals = electricals; }

    public List<StaffAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<StaffAssignment> assignments) { this.assignments = assignments; }

    public List<MaintenanceTask> getTasks() { return tasks; }
    public void setTasks(List<MaintenanceTask> tasks) { this.tasks = tasks; }
}