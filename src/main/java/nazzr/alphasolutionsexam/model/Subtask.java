package nazzr.alphasolutionsexam.model;

public class Subtask {
    private int subTaskID;
    private String title;
    private String description;
    private int estimated_time;
    private int final_time;
    private int taskID;

    public Subtask() {
    }

    public Subtask(int subTaskID, String title, String description, int estimated_time, int final_time, int taskID) {
        this.subTaskID = subTaskID;
        this.title = title;
        this.description = description;
        this.estimated_time = estimated_time;
        this.final_time = final_time;
        this.taskID = taskID;
    }

    public int getSubTaskID() {
        return subTaskID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimated_time() {
        return estimated_time;
    }

    public int getFinal_time() {
        return final_time;
    }

    public int getTaskID() {
        return taskID;
    }

    public Subtask setSubTaskID(int subTaskID) {
        this.subTaskID = subTaskID;
        return this;
    }

    public Subtask setTitle(String title) {
        this.title = title;
        return this;
    }

    public Subtask setDescription(String description) {
        this.description = description;
        return this;
    }

    public Subtask setEstimated_time(int estimated_time) {
        this.estimated_time = estimated_time;
        return this;
    }

    public Subtask setFinal_time(int final_time) {
        this.final_time = final_time;
        return this;
    }

    public Subtask setTaskID(int taskID) {
        this.taskID = taskID;
        return this;
    }
}
