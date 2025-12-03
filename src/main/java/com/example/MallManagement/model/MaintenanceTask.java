package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class MaintenanceTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Beschreibung erforderlich")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Positive(message = "Dauer muss positiv sein")
    private int duration;

    // Task gehört zu einem Floor (wie in der Floor-Klasse definiert)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    public enum Status { Planned, Active, Done }

    public MaintenanceTask() {}

    public MaintenanceTask(String description, Status status, int duration, Floor floor) {
        this.description = description;
        this.status = status;
        this.duration = duration;
        this.floor = floor;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }
}