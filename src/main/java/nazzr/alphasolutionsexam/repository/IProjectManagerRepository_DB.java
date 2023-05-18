package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.dto.SubtaskDTO;
import nazzr.alphasolutionsexam.model.*;

import java.util.List;

public interface IProjectManagerRepository_DB {

    //--------------------------------------------------PROJECT-------------------------------------------------------\\
    Project createProject(Project project);

    void deleteProject(int projectID);

    Project getProjectByID(int project_id);

    List<Project> getProjects(User user);

    void updateProject(Project project);

    //--------------------------------------------------EMPLOYEE------------------------------------------------------\\
    Employee createEmployee(Employee employee);

    Employee getEmployeeByID(int employeeID);

    List<Employee> getEmployees(User user);

    void deleteEmployee(int employeeID);

    void updateEmployee(Employee employee);

    //---------------------------------------------------TASK---------------------------------------------------------\\
    Task createTask(Task task, int project_id);

    Task getTaskByID(int task_id);

    List<Task> getTasks(int project_id);
    void updateTask(Task task);

    void deleteTask(int subTaskID);

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\
    void createSubtask(Subtask subtask, int taskID, List<Integer> employeeIDs);

    Subtask getSubTaskByID(int subTaskID);

    List<SubtaskDTO> getSubtasks(int taskID);
    void updateSubtask(Subtask subtask);
    void updateSubtaskStatus(int subTaskID, boolean isDone);

    void deleteSubtask(int taskID);
}
