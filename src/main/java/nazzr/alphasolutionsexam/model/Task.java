package nazzr.alphasolutionsexam.model;

public class Task {
    private int taskID;
    private String title;
    private String description;
    private int projectID;

    public Task(int taskID, String title, String description, int projectID) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.projectID = projectID;
    }

    public Task() {

    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
