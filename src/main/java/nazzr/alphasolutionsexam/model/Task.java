package nazzr.alphasolutionsexam.model;

public class Task {
    private int TaskID;
    private String title;
    private String description;
    private boolean isDone;

    public Task() {}

    public Task(int taskID, String title, String description, boolean isDone) {
        TaskID = taskID;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    //----------------------------------------------------Getter-----------------------------------------------------\\
    public int getTaskID() { return TaskID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isDone() { return isDone; }

    //----------------------------------------------------Setter------------------------------------------------------\\
    public void setTaskID(int taskID) { TaskID = taskID; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { isDone = done; }
}
