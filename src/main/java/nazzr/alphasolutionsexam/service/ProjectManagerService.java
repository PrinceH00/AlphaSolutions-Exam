package nazzr.alphasolutionsexam.service;

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

    public List<Project> getProjects(User user) {
        return iProjectManagerRepositoryDb.getAllProjects(user);
    }

    public void deleteProject(int projectID) {
        iProjectManagerRepositoryDb.deleteProject(projectID);
    }

    //--------------------------------------------------EMPLOYEE------------------------------------------------------\\

    public Employee createEmployee(Employee employee) {
        return iProjectManagerRepositoryDb.createEmployee(employee);
    }

    public List<Employee> getEmployees(User user) {
        return iProjectManagerRepositoryDb.getEmployees(user);
    }

    public void deleteEmployee(int employeeID) {
        iProjectManagerRepositoryDb.deleteEmployee(employeeID);
    }

    //---------------------------------------------------TASK---------------------------------------------------------\\

    public Task createTask(Task task, int projectID) {
        return iProjectManagerRepositoryDb.createTask(task, projectID);
    }

    public Task getTaskByID(int taskID) {
        return iProjectManagerRepositoryDb.getTaskByID(taskID);
    }

    public List<Task> getTasks(int projectID) {
        return iProjectManagerRepositoryDb.getAllTasks(projectID);
    }

    public void deleteTask(int taskID) {
        iProjectManagerRepositoryDb.deleteTask(taskID);
    }

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\
    public Subtask createSubtask(Subtask subtask, int taskID) {
        return iProjectManagerRepositoryDb.createSubtask(subtask, taskID);
    }

    public List<Subtask> getSubtasks(int taskID) {
        return iProjectManagerRepositoryDb.getSubtasks(taskID);
    }

    public void deleteSubtask(int taskID) {
        iProjectManagerRepositoryDb.deleteSubtask(taskID);
    }
}
