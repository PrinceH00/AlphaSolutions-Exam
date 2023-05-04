package nazzr.alphasolutionsexam.model;

import java.util.Date;

public class Project {
    private int projectID;
    private String title;
    private String description;
    private Date startDate;
    private Date deadlineDate;
    private Date finalDate;
    private boolean isDone;
    private int userID;

    public Project() {}

    public Project(int projectID, String title, String description, Date startDate, Date deadlineDate, Date finalDate, boolean isDone, int userID) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.finalDate = finalDate;
        this.isDone = isDone;
        this.userID = userID;
    }

    //----------------------------------------------------Getter-----------------------------------------------------\\
    public int getProjectID() { return projectID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Date getStartDate() { return startDate; }
    public Date getDeadlineDate() { return deadlineDate; }
    public Date getFinalDate() { return finalDate; }
    public boolean isDone() { return isDone; }
    public int getUserID() {
        return userID;
    }

    //----------------------------------------------------Setter-----------------------------------------------------\\
    public void setProjectID(int projectID) { this.projectID = projectID; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setDeadlineDate(Date deadlineDate) { this.deadlineDate = deadlineDate; }
    public void setFinalDate(Date finalDate) { this.finalDate = finalDate; }
    public void setDone(boolean done) { isDone = done; }
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
