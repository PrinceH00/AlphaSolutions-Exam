package nazzr.alphasolutionsexam.model;

import java.util.Date;

public class Project {
    private int projectID;
    private String title;
    private String discription;
    private Date startDate;
    private Date deadlineDate;
    private Date finalDate;
    private boolean isDone;

    public Project() {
    }

    public Project(int projectID, String title, String discription, Date startDate, Date deadlineDate, Date finalDate, boolean isDone) {
        this.projectID = projectID;
        this.title = title;
        this.discription = discription;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.finalDate = finalDate;
        this.isDone = isDone;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public Project setProjectID(int projectID) {
        this.projectID = projectID;
        return this;
    }

    public Project setTitle(String title) {
        this.title = title;
        return this;
    }

    public Project setDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    public Project setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Project setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
        return this;
    }

    public Project setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
        return this;
    }

    public Project setDone(boolean done) {
        isDone = done;
        return this;
    }
}
