package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.Subtask;
import nazzr.alphasolutionsexam.model.Task;
import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//
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

    public Project getProjectByID(int project_id) {
        try {
            SQL = "SELECT * FROM project WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, project_id);
            resultSet = preparedStatement.executeQuery(SQL);
            Project project = null;
            while (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                LocalDate startDate = resultSet.getDate(4).toLocalDate();
                LocalDate deadlineDate = resultSet.getDate(5).toLocalDate();
                LocalDate finalDate = resultSet.getDate(6).toLocalDate();
                int userID = resultSet.getInt(7);
                project = new Project(project_id, title, description, startDate, deadlineDate, finalDate, userID);
            }
            return project;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Task createTask(Task task, int project_id) {
        try {
            SQL = "INSERT INTO Task (title, description, project_id) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, project_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return task;
    }

    public List<Task> getTasksByProjectID(int project_id) {
        List<Task> taskList = new ArrayList<>();
        try {
            SQL = "SELECT * FROM Task WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, project_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int taskID = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int projectID = resultSet.getInt(4);
                taskList.add(new Task(taskID, title, description, projectID));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return taskList;
    }

    public Subtask createSubtask(Subtask subtask, int taskID) {
        try {
            SQL = "INSERT INTO Subtask (title, description, estimated_time, final_time, task_id) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, subtask.getTitle());
            preparedStatement.setString(2, subtask.getDescription());
            preparedStatement.setInt(3, subtask.getEstimated_time());
            preparedStatement.setInt(4, subtask.getFinal_time());
            preparedStatement.setInt(5, taskID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return subtask;
    }


    public List<Subtask> getSubtasks(int taskID) {
        List<Subtask> subtasks = new ArrayList<>();
        try {
            SQL = "SELECT * FROM Subtask WHERE task_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, taskID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int subtaskID = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int estimated_time = resultSet.getInt(4);
                int final_time = resultSet.getInt(5);
                int task_ID = resultSet.getInt(6);
                subtasks.add(new Subtask(subtaskID, title, description, estimated_time, final_time, task_ID));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return subtasks;
    }
}
