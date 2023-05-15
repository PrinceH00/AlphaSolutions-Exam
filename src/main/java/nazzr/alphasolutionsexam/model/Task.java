package nazzr.alphasolutionsexam.model;

public class Task {
    private int taskID;
    private String title;
    private String description;
    private int projectID;

    public Task() {
    }

    public Task(int taskID, String title, String description, int projectID) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.projectID = projectID;
    }

    //---------------------------------------------------Getter-------------------------------------------------------\\

    public int getTaskID() {
        return taskID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getProjectID() {
        return projectID;
    }

    //---------------------------------------------------Setter-------------------------------------------------------\\

    public Task setTaskID(int taskID) {
        this.taskID = taskID;
        return this;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Task setProjectID(int projectID) {
        this.projectID = projectID;
        return this;
    }
}
