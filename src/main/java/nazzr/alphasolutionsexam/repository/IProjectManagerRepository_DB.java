package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.*;
import java.util.List;

public interface IProjectManagerRepository_DB {

    //--------------------------------------------------PROJECT-------------------------------------------------------\\
    Project createProject(Project project);

    void deleteProject(int projectID);

    Project getProjectByID(int project_id);

    List<Project> getAllProjects(User user);

    //--------------------------------------------------EMPLOYEE------------------------------------------------------\\
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees(User user);

    void deleteEmployee(int employeeID);

    //---------------------------------------------------TASK---------------------------------------------------------\\
    Task createTask(Task task, int project_id);

    Task getTaskByID(int task_id);

    List<Task> getAllTasks(int project_id);

    void deleteTask(int taskID);

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\
    Subtask createSubtask(Subtask subtask, int taskID);

    List<Subtask> getSubtasks(int taskID);

    void deleteSubtask(int taskID);

}
