package nazzr.alphasolutionsexam.service;

import nazzr.alphasolutionsexam.dto.ProjectTimeDTO;
import nazzr.alphasolutionsexam.dto.SubtaskDTO;
import nazzr.alphasolutionsexam.model.*;
import nazzr.alphasolutionsexam.repository.IProjectManagerRepository_DB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagerService {
    private final IProjectManagerRepository_DB iProjectManagerRepositoryDb;

    public ProjectManagerService(ApplicationContext context, @Value("projectManagerRepo") String impl) {
        iProjectManagerRepositoryDb = (IProjectManagerRepository_DB) context.getBean(impl);
    }

    //--------------------------------------------------PROJECT-------------------------------------------------------\\

    public Project createProject(Project project) {
        return iProjectManagerRepositoryDb.createProject(project);
    }

    public Project getProjectByID(int projectID) {
        return iProjectManagerRepositoryDb.getProjectByID(projectID);
    }

    public List<ProjectTimeDTO> getProjects(User user) {
        return iProjectManagerRepositoryDb.getProjects(user);
    }

    public void deleteProject(int projectID) {
        iProjectManagerRepositoryDb.deleteProject(projectID);
    }

    public void updateProject(Project project) {
        iProjectManagerRepositoryDb.updateProject(project);
    }

    //--------------------------------------------------EMPLOYEE------------------------------------------------------\\

    public Employee createEmployee(Employee employee) {
        return iProjectManagerRepositoryDb.createEmployee(employee);
    }

    public Employee getEmployeeByID(int employeeID) {
        return iProjectManagerRepositoryDb.getEmployeeByID(employeeID);
    }

    public List<Employee> getEmployees(User user) {
        return iProjectManagerRepositoryDb.getEmployees(user);
    }

    public void deleteEmployee(int employeeID) {
        iProjectManagerRepositoryDb.deleteEmployee(employeeID);
    }

    public void updateEmployee(Employee employee) {
        iProjectManagerRepositoryDb.updateEmployee(employee);
    }

    //---------------------------------------------------TASK---------------------------------------------------------\\

    public Task createTask(Task task, int projectID) {
        return iProjectManagerRepositoryDb.createTask(task, projectID);
    }

    public Task getTaskByID(int taskID) {
        return iProjectManagerRepositoryDb.getTaskByID(taskID);
    }

    public List<Task> getTasks(int projectID) {
        return iProjectManagerRepositoryDb.getTasks(projectID);
    }

    public void updateTask(Task task) {
        iProjectManagerRepositoryDb.updateTask(task);
    }

    public void deleteTask(int taskID) {
        iProjectManagerRepositoryDb.deleteTask(taskID);
    }

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\
    public void createSubtask(Subtask subtask, int taskID, List<Integer> employeeIDs) {
        iProjectManagerRepositoryDb.createSubtask(subtask, taskID, employeeIDs);
    }
    public Subtask getSubTaskByID(int subTaskID) {
        return iProjectManagerRepositoryDb.getSubTaskByID(subTaskID);
    }

    public List<SubtaskDTO> getSubtasks(int taskID) {
        return iProjectManagerRepositoryDb.getSubtasks(taskID);
    }

    public void updateSubtask(Subtask subtask, List<Integer> assignedEmployeeIDs) {
        iProjectManagerRepositoryDb.updateSubtask(subtask, assignedEmployeeIDs);
    }
    public List<Integer> getAssignedEmployeeIDs(int subtaskID) {
        return iProjectManagerRepositoryDb.getAssignedEmployeeIDs(subtaskID);
    }
    public void updateSubtaskStatus(int subtaskID, boolean isDone){
        iProjectManagerRepositoryDb.updateSubtaskStatus(subtaskID, isDone);
    }

    public void deleteSubtask(int subTaskID) {
        iProjectManagerRepositoryDb.deleteSubtask(subTaskID);
    }

}
