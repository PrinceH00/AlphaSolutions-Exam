package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.*;
import nazzr.alphasolutionsexam.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//
@Repository("projectManagerRepo")
public class ProjectManagerRepository_DB implements IProjectManagerRepository_DB {

    String SQL = null;
    Connection connection = DB_Connector.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //--------------------------------------------------PROJECT-------------------------------------------------------\\
    @Override
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

    @Override
    public Project getProjectByID(int projectID) {
        try {
            SQL = "SELECT * FROM project WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, projectID);
            resultSet = preparedStatement.executeQuery(SQL);

            Project project = null;
            while (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                LocalDate startDate = resultSet.getDate(4).toLocalDate();
                LocalDate deadlineDate = resultSet.getDate(5).toLocalDate();
                LocalDate finalDate = resultSet.getDate(6).toLocalDate();
                int userID = resultSet.getInt(7);

                project = new Project(projectID, title, description, startDate, deadlineDate, finalDate, userID);
            }

            return project;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
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

    @Override
    public void deleteProject(int projectID) {
        try {
            String SQL = "DELETE FROM Project WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------------------------------------EMPLOYEE------------------------------------------------------\\
    @Override
    public Employee createEmployee(Employee employee) {
        try {
            String SQL = "INSERT INTO Employee (firstname, lastname, email, job, user_id) VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getJob());
            preparedStatement.setInt(5, employee.getUserID());
            preparedStatement.executeUpdate();

            return employee;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getEmployees(User user) {
        List<Employee> employees = new ArrayList<>();
        try {
            SQL = "SELECT * FROM Employee WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getUserID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeID = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String job = resultSet.getString(5);
                int userID = resultSet.getInt(6);

                employees.add(new Employee(employeeID, firstName, lastName, email, job, userID));
            }

            return employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(int employeeID) {
        try {
            String SQL = "DELETE FROM Employee WHERE employee_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, employeeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------TASK---------------------------------------------------------\\
    @Override
    public Task createTask(Task task, int projectID) {
        try {
            SQL = "INSERT INTO Task (title, description, project_id) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, projectID);
            preparedStatement.executeUpdate();

            return task;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Task getTaskByID(int taskID) {
        try {
            SQL = "SELECT * FROM Task WHERE task_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, taskID);
            resultSet = preparedStatement.executeQuery();

            Task task = null;
            if (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int projectID = resultSet.getInt(4);

                task = new Task(taskID, title, description, projectID);
            }

            return task;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Task> getAllTasks(int projectID) {
        List<Task> taskList = new ArrayList<>();
        try {
            SQL = "SELECT * FROM Task WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, projectID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int taskID = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int project_id = resultSet.getInt(4);

                taskList.add(new Task(taskID, title, description, project_id));
            }

            return taskList;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteTask(int taskID) {
        try {
            String SQL = "DELETE FROM Task WHERE task_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, taskID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\
    @Override
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

            return subtask;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
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

            return subtasks;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteSubtask(int taskID) {
        try {
            String SQL = "DELETE FROM Subtask WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, taskID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
