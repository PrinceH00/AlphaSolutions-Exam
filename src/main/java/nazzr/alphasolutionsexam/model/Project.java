package nazzr.alphasolutionsexam.model;

import java.time.LocalDate;

public class Project {
    private int projectID;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate deadlineDate;
    private LocalDate finalDate;
    private int userID;

    public Project() {
    }

    public Project(int projectID, String title, String description, LocalDate startDate, LocalDate deadlineDate, LocalDate finalDate, int userID) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.finalDate = finalDate;
        this.userID = userID;
    }

    //---------------------------------------------------Getter-------------------------------------------------------\\

    public int getProjectID() {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public int getUserID() {
        return userID;
    }

    //---------------------------------------------------Setter-------------------------------------------------------\\

    public Project setProjectID(int projectID) {
        this.projectID = projectID;
        return this;
    }

    public Project setTitle(String title) {
        this.title = title;
        return this;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public Project setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Project setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
        return this;
    }

    public Project setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
        return this;
    }

    public Project setUserID(int userID) {
        this.userID = userID;
        return this;
    }
}
