package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.DTO.ViewProjectDTO;
import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.*;
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
            SQL = "INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, isDone, user_id) VALUES(?,?,?,?,?,?,?))";
            PreparedStatement ps = connection.prepareStatement(SQL);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, (Date) project.getStartDate());
            preparedStatement.setDate(4, (Date) project.getDeadlineDate());
            preparedStatement.setDate(5, (Date) project.getFinalDate());
            preparedStatement.setBoolean(6, project.isDone());
            ps.executeUpdate();

            return project;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public List<ViewProjectDTO> getAllProjects(User user) {
        try {
            SQL = "SELECT title, project_id FROM Project WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getUserID());
            resultSet = preparedStatement.executeQuery();
            List<ViewProjectDTO> viewProject = new ArrayList<>();
            while (resultSet.next()) {
                viewProject.add(new ViewProjectDTO(resultSet.getString("title"), resultSet.getInt("project_id"), user.getUserID()));
            }
            return viewProject;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
