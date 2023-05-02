package nazzr.alphasolutionsexam.model;

public class SubTask {
    private int subTaskID;
    private String title;
    private String description;
    private int estimated_time;
    private int final_time;
    private boolean isDone;

    public SubTask() {}

    public SubTask(int subTaskID, String title, String description, int estimated_time, int final_time, boolean isDone) {
        this.subTaskID = subTaskID;
        this.title = title;
        this.description = description;
        this.estimated_time = estimated_time;
        this.final_time = final_time;
        this.isDone = isDone;
    }

    //----------------------------------------------------Getter-----------------------------------------------------\\-\\
    public int getSubTaskID() { return subTaskID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getEstimated_time() { return estimated_time; }
    public int getFinal_time() { return final_time; }
    public boolean isDone() { return isDone; }

    //----------------------------------------------------Setter-----------------------------------------------------\\
    public void setSubTaskID(int subTaskID) { this.subTaskID = subTaskID; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setEstimated_time(int estimated_time) { this.estimated_time = estimated_time; }
    public void setFinal_time(int final_time) { this.final_time = final_time; }
    public void setDone(boolean done) { isDone = done; }

}
