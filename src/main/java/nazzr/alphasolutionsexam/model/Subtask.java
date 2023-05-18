package nazzr.alphasolutionsexam.model;

public class Subtask {
    private int subtaskID;
    private String title;
    private String description;
    private int estimated_time;
    private int final_time;
    private boolean isDone;
    private int taskID;

    public Subtask() {
    }

    public Subtask(int subtaskID, String title, String description, int estimated_time, int final_time, boolean isDone, int taskID) {
        this.subtaskID = subtaskID;
        this.title = title;
        this.description = description;
        this.estimated_time = estimated_time;
        this.final_time = final_time;
        this.isDone = isDone;
        this.taskID = taskID;
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

    public int getEstimated_time() {
        return estimated_time;
    }

    public void setEstimated_time(int estimated_time) {
        this.estimated_time = estimated_time;
    }

    public int getFinal_time() {
        return final_time;
    }

    public void setFinal_time(int final_time) {
        this.final_time = final_time;
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
}
