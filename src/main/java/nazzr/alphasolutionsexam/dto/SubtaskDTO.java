package nazzr.alphasolutionsexam.dto;

import nazzr.alphasolutionsexam.model.Employee;

import java.util.List;

public class SubtaskDTO {
    private int subtaskID;
    private String title;
    private String description;
    private int estimatedTime;
    private int finalTime;
    private boolean isDone;
    private int taskID;
    private List<Employee> assignedEmployees;

    public SubtaskDTO() {
    }

    public SubtaskDTO(int subtaskID, String title, String description, int estimatedTime, int finalTime, boolean isDone, int taskID, List<Employee> assignedEmployees) {
        this.subtaskID = subtaskID;
        this.title = title;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.finalTime = finalTime;
        this.isDone = isDone;
        this.taskID = taskID;
        this.assignedEmployees = assignedEmployees;
    }

    public int getSubtaskID() {
        return subtaskID;
    }

    public void setSubtaskID(int subtaskID) {
        this.subtaskID = subtaskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(int finalTime) {
        this.finalTime = finalTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }
}
