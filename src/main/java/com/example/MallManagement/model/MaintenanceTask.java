package com.example.MallManagement.model;

public class MaintenanceTask implements Identifiable{
    private String id;
    private String description;
    private Status status;
    private String assignmentId;
    private int duration;

    public enum Status {
        Planned, Active, Done
    };

    public MaintenanceTask() {}

    public MaintenanceTask(String id, String description, Status status, String assignmentId, int duration) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.assignmentId = assignmentId;
        this.duration = duration;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getAssignmentId() { return assignmentId; }
    public void setAssignmentId(String assignmentId) { this.assignmentId = assignmentId; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}
