package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.dto.SubtaskDTO;
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
            resultSet = preparedStatement.executeQuery();

            Project project = null;

            while (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                LocalDate startDate = resultSet.getDate(4).toLocalDate();
                LocalDate deadlineDate = resultSet.getDate(5).toLocalDate();
                LocalDate finalDate = null;
                if (resultSet.getDate(6) != null) {
                    finalDate = resultSet.getDate(6).toLocalDate();
                }
                int userID = resultSet.getInt(7);

                project = new Project(projectID, title, description, startDate, deadlineDate, finalDate, userID);
            }
            return project;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Project> getProjects(User user) {
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

    public void updateProject(Project project) {
        try {
            String SQL = "UPDATE Project SET title = ?, description = ?, startDate = ?, deadlineDate = ?, finalDate = ? WHERE project_id = ?";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
            preparedStatement.setDate(4, Date.valueOf(project.getDeadlineDate()));

            if (project.getFinalDate() != null) {
                preparedStatement.setDate(5, Date.valueOf(project.getFinalDate()));
            } else {
                preparedStatement.setObject(5, null);
            }
            preparedStatement.setInt(6, project.getProjectID());
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
    public Employee getEmployeeByID(int employeeID) {
        try {
            SQL = "SELECT * FROM Employee WHERE employee_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, employeeID);
            resultSet = preparedStatement.executeQuery();

            Employee employee = null;

            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String job = resultSet.getString(5);
                int userID = resultSet.getInt(6);

                employee = new Employee(employeeID, firstName, lastName, email, job, userID);
            }
            return employee;

        } catch (SQLException e) {
            throw new RuntimeException();
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

    @Override
    public void updateEmployee(Employee employee) {
        try {
            String SQL = "UPDATE Employee SET firstname = ?, lastname = ?, email = ?, job = ? WHERE employee_id = ?";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getJob());
            preparedStatement.setInt(5, employee.getEmployeeID());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
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
    public List<Task> getTasks(int projectID) {
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
    public void updateTask(Task task) {
        try {
            String SQL = "UPDATE Task SET title = ?, description = ? WHERE task_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getTaskID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void createSubtask(Subtask subtask, int taskID, List<Integer> employeeIDs) {
        try {
            String SQL = "INSERT INTO Subtask (title, description, estimated_time, final_time, task_id) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, subtask.getTitle());
            preparedStatement.setString(2, subtask.getDescription());
            preparedStatement.setInt(3, subtask.getEstimated_time());
            preparedStatement.setInt(4, subtask.getFinal_time());
            preparedStatement.setInt(5, taskID);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            int subtaskID;
            if (generatedKeys.next()) {
                subtaskID = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating subtask failed, no ID found");
            }

            if (employeeIDs != null && !employeeIDs.isEmpty()) {
                SQL = "INSERT INTO EmployeeSubtask (employee_id, subtask_id) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(SQL);
                for (int employeeID : employeeIDs) {
                    preparedStatement.setInt(1, employeeID);
                    preparedStatement.setInt(2, subtaskID);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }

            subtask.setSubtaskID(subtaskID);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Subtask getSubTaskByID(int subTaskID) {
        try {
            SQL = "SELECT * FROM SubTask WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, subTaskID);
            resultSet = preparedStatement.executeQuery();

            Subtask subtask = null;
            if (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int estimated_time = resultSet.getInt(4);
                int final_time = resultSet.getInt(5);
                boolean isDone = resultSet.getBoolean(6);
                int taskID = resultSet.getInt(7);

                subtask = new Subtask(subTaskID, title, description, estimated_time, final_time, isDone, taskID);
            }

            return subtask;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubtaskDTO> getSubtasks(int taskID) {
        List<SubtaskDTO> subtasks = new ArrayList<>();
        try {
            SQL = "SELECT Subtask.subtask_id, Subtask.title, Subtask.description, Subtask.estimated_time, Subtask.final_time, Subtask.isDone, Subtask.task_id, Employee.employee_id, Employee.firstname, Employee.lastname " +
                    "FROM Subtask " +
                    "LEFT JOIN EmployeeSubtask ON Subtask.subtask_id = EmployeeSubtask.subtask_id " +
                    "LEFT JOIN Employee ON EmployeeSubtask.employee_id = Employee.employee_id " +
                    "WHERE Subtask.task_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, taskID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int subtaskID = resultSet.getInt(1);
                SubtaskDTO subtaskDTO = null;

                // Vi tjekker for om subtask allerede eksisterer for at undgå duplikater
                for (SubtaskDTO existingSubtaskDTO : subtasks) {
                    if (existingSubtaskDTO.getSubtaskID() == subtaskID) {
                        subtaskDTO = existingSubtaskDTO;
                        break;
                    }
                }

                // Hvis den ikke eksisterer tilføjer vi den til listen
                if (subtaskDTO == null) {
                    subtaskDTO = new SubtaskDTO();
                    subtaskDTO.setSubtaskID(subtaskID);
                    subtaskDTO.setTitle(resultSet.getString(2));
                    subtaskDTO.setDescription(resultSet.getString(3));
                    subtaskDTO.setEstimatedTime(resultSet.getInt(4));
                    subtaskDTO.setFinalTime(resultSet.getInt(5));
                    subtaskDTO.setDone(resultSet.getBoolean(6));
                    subtaskDTO.setTaskID(resultSet.getInt(7));
                    subtaskDTO.setAssignedEmployees(new ArrayList<>()); // vi instantierer en employee liste, så vi kan tage højde for om der er flere employees på en subtask

                    subtasks.add(subtaskDTO);
                }

                // vi checker om en employee er assigned til en subtask, og dernæst opretter vi og tilføjer et employee objekt
                if (resultSet.getInt(8) != 0) {
                    Employee employee = new Employee(resultSet.getInt(8), resultSet.getString(9), resultSet.getString(10), null, null, 0);
                    subtaskDTO.getAssignedEmployees().add(employee);
                }
            }

            return subtasks;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateSubtask(Subtask subtask, List<Integer> assignedEmployeeIDs) {
        try {
            String SQL = "UPDATE Subtask SET title = ?, description = ?, estimated_time = ?, final_time = ?, isDone = ? WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, subtask.getTitle());
            preparedStatement.setString(2, subtask.getDescription());
            preparedStatement.setInt(3, subtask.getEstimated_time());
            preparedStatement.setInt(4, subtask.getFinal_time());
            preparedStatement.setBoolean(5, subtask.isDone());
            preparedStatement.setInt(6, subtask.getSubtaskID());
            preparedStatement.executeUpdate();

            updateAssignedEmployees(subtask.getSubtaskID(), assignedEmployeeIDs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAssignedEmployees(int subtaskID, List<Integer> assignedEmployeeIDs) {
        try {
            SQL = "DELETE FROM EmployeeSubtask WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, subtaskID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            SQL = "INSERT INTO EmployeeSubtask (employee_id, subtask_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            for (Integer employeeID : assignedEmployeeIDs) {
                preparedStatement.setInt(1, employeeID);
                preparedStatement.setInt(2, subtaskID);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Integer> getAssignedEmployeeIDs(int subtaskID) {
        List<Integer> assignedEmployeeIDs = new ArrayList<>();
        try {
            String SQL = "SELECT employee_id FROM EmployeeSubtask WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, subtaskID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeID = resultSet.getInt(1);
                assignedEmployeeIDs.add(employeeID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return assignedEmployeeIDs;
    }
    @Override
    public void updateSubtaskStatus(int subTaskID, boolean isDone) {
        try {
            SQL = "UPDATE Subtask SET isDone = ? WHERE subtask_id  = ?";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setBoolean(1, isDone);
            preparedStatement.setInt(2, subTaskID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteSubtask(int subtaskID) {
        try {
            String SQL = "DELETE FROM Subtask WHERE subtask_id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, subtaskID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
