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

    public ProjectManagerService(ApplicationContext context, @Value("projectRepo") String impl) {
        iProjectManagerRepositoryDb = (IProjectManagerRepository_DB) context.getBean(impl);
    }

    public Project createProject(Project project) {
        return iProjectManagerRepositoryDb.createProject(project);
    }

    public void deleteProject(int projectID) {
        iProjectManagerRepositoryDb.deleteProject(projectID);
    }

    public List<Project> getAllProjects(User user) {
        return iProjectManagerRepositoryDb.getAllProjects(user);
    }

    public Project getProjectByID(int project_id) {
        return iProjectManagerRepositoryDb.getProjectByID(project_id);
    }

    public Task createTask(Task task, int project_id) {
        return iProjectManagerRepositoryDb.createTask(task, project_id);
    }

    public List<Task> getAllTask(int project_id) {
        return iProjectManagerRepositoryDb.getAllTasks(project_id);
    }

    public Task getTaskByID (int task_id) {
        return iProjectManagerRepositoryDb.getTaskByID(task_id);
    }
    public void deleteTask(int taskID){
        iProjectManagerRepositoryDb.deleteTask(taskID);
    }

    public Subtask createSubtask(Subtask subtask, int taskID) {
        return iProjectManagerRepositoryDb.createSubtask(subtask, taskID);
    }

    public List<Subtask> getSubtasks(int taskID) {
        return iProjectManagerRepositoryDb.getSubtasks(taskID);
    }

    public void deleteSubtask(int taskID){
        iProjectManagerRepositoryDb.deleteSubtask(taskID);
    }
    public Employee createEmployee(Employee employee) {
        return iProjectManagerRepositoryDb.createEmployee(employee);
    }

    public List<Employee> getEmployees(User user) {
            return iProjectManagerRepositoryDb.getEmployees(user);
    }

    public void deleteEmployee(int employeeID) {
        iProjectManagerRepositoryDb.deleteEmployee(employeeID);
    }
}
