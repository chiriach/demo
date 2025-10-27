package com.example.MallManagement.model;

public class MaintananceTask{
    private String id;
    private String description;
    private String status;
    private String assignmentId;

    public MaintananceTask(String id, String description, String status, String assignmentId) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.assignmentId = assignmentId;

        if(!this.status.equals("Planned") && !this.status.equals("Active") && !this.status.equals("Done") ){
            throw new IllegalArgumentException();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }
}
