package com.example.MallManagement.model;

public class MaintenanceTask {
    private String id;
    private String description;
    private String status;
    private String assignmentId;
    private int duration;

    public MaintenanceTask() {} // ✅ Required for Spring binding

    public MaintenanceTask(String id, String description, String status, String assignmentId, int duration) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.assignmentId = assignmentId;
        this.duration = duration;

        if(!this.status.equals("Planned") && !this.status.equals("Active") && !this.status.equals("Done")) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignmentId() { return assignmentId; }
    public void setAssignmentId(String assignmentId) { this.assignmentId = assignmentId; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}
