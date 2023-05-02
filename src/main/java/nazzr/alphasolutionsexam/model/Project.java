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

    public Project() {}

    public Project(int projectID, String title, String discription, Date startDate, Date deadlineDate, Date finalDate, boolean isDone) {
        this.projectID = projectID;
        this.title = title;
        this.discription = discription;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.finalDate = finalDate;
        this.isDone = isDone;
    }

    //----------------------------------------------------Getter-----------------------------------------------------\\
    public int getProjectID() { return projectID; }
    public String getTitle() { return title; }
    public String getDiscription() { return discription; }
    public Date getStartDate() { return startDate; }
    public Date getDeadlineDate() { return deadlineDate; }
    public Date getFinalDate() { return finalDate; }
    public boolean isDone() { return isDone; }

    //----------------------------------------------------Setter-----------------------------------------------------\\
    public void setProjectID(int projectID) { this.projectID = projectID; }
    public void setTitle(String title) { this.title = title; }
    public void setDiscription(String discription) { this.discription = discription; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setDeadlineDate(Date deadlineDate) { this.deadlineDate = deadlineDate; }
    public void setFinalDate(Date finalDate) { this.finalDate = finalDate; }
    public void setDone(boolean done) { isDone = done; }
}
