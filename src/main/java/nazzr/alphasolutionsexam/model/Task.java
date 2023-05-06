package nazzr.alphasolutionsexam.model;

public class Task {
    private int TaskID;
    private String title;
    private String description;

    public Task() {}

    public Task(int taskID, String title, String description) {
        TaskID = taskID;
        this.title = title;
        this.description = description;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
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
}
