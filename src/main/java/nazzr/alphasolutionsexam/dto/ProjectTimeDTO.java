package nazzr.alphasolutionsexam.dto;

import java.time.LocalDate;

public class ProjectTimeDTO {
    private int projectID;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate deadlineDate;
    private LocalDate finalDate;
    private int userID;
    int total_estimated_time;
    int total_final_time;

    public ProjectTimeDTO() {
    }

    public ProjectTimeDTO(int projectID, String title, String description, LocalDate startDate, LocalDate deadlineDate, LocalDate finalDate, int userID, int total_estimated_time, int total_final_time) {
        this.projectID = projectID;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.finalDate = finalDate;
        this.userID = userID;
        this.total_estimated_time = total_estimated_time;
        this.total_final_time = total_final_time;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTotal_estimated_time() {
        return total_estimated_time;
    }

    public void setTotal_estimated_time(int total_estimated_time) {
        this.total_estimated_time = total_estimated_time;
    }

    public int getTotal_final_time() {
        return total_final_time;
    }

    public void setTotal_final_time(int total_final_time) {
        this.total_final_time = total_final_time;
    }
}
