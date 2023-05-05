package nazzr.alphasolutionsexam.DTO;

public class ViewProjectDTO {
    private int projectID;
    private String title;
    private int userID;

    public ViewProjectDTO(String title, int projectID, int userID) {
        this.projectID = projectID;
        this.title = title;
        this.userID = userID;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public int getUserID() {
        return userID;
    }


    public ViewProjectDTO setProjectID(int projectID) {
        this.projectID = projectID;
        return this;
    }

    public ViewProjectDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public ViewProjectDTO setUserID(int userID) {
        this.userID = userID;
        return this;
    }
}
