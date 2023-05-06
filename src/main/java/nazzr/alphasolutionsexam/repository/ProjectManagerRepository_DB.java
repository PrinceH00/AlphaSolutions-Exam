package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository("projectRepo")
public class ProjectManagerRepository_DB implements IProjectManagerRepository_DB {

    String SQL = null;
    Connection connection = DB_Connector.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public Project createProject(Project project) {
        try {
            String SQL = "INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, user_id) VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
            preparedStatement.setDate(4, Date.valueOf(project.getDeadlineDate()));

            // Check if finalDate is null and set the value accordingly
            if (project.getFinalDate() != null) {
                preparedStatement.setDate(5, Date.valueOf(project.getFinalDate()));
            } else {
                preparedStatement.setObject(5, null);
            }

            preparedStatement.setInt(6, project.getUserID());
            preparedStatement.executeUpdate();

            return project;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Project> getAllProjects(User user) {
        List<Project> projectList = new ArrayList<>();
        try {
            SQL = "SELECT * FROM Project WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getUserID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int projectID = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                LocalDate startDate = resultSet.getDate(4).toLocalDate();
                LocalDate deadlineDate = resultSet.getDate(5).toLocalDate();
                LocalDate finalDate = null;
                if (resultSet.getDate(6) != null) {
                    finalDate = resultSet.getDate(6).toLocalDate();
                }
                int userID = resultSet.getInt(7);
                projectList.add(new Project(projectID, title, description, startDate, deadlineDate, finalDate, userID));
            }
            return projectList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
