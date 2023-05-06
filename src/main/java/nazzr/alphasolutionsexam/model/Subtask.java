package nazzr.alphasolutionsexam.model;

public class Subtask {
    private int subTaskID;
    private String title;
    private String description;
    private int estimated_time;
    private int final_time;

    public Subtask() {
    }

    public Subtask(int subTaskID, String title, String description, int estimated_time, int final_time) {
        this.subTaskID = subTaskID;
        this.title = title;
        this.description = description;
        this.estimated_time = estimated_time;
        this.final_time = final_time;
    }

    public int getSubTaskID() {
        return subTaskID;
    }

    public void setSubTaskID(int subTaskID) {
        this.subTaskID = subTaskID;
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
}
