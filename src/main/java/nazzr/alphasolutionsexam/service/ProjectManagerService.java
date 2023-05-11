package nazzr.alphasolutionsexam.service;

import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.Subtask;
import nazzr.alphasolutionsexam.model.Task;
import nazzr.alphasolutionsexam.model.User;
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

    public List<Project> getAllProjects(User user) {
        return iProjectManagerRepositoryDb.getAllProjects(user);
    }

    public Task createTask(Task task, int project_id) {
        return iProjectManagerRepositoryDb.createTask(task, project_id);
    }

    public List<Task> getAllTask(int project_id) {
        return iProjectManagerRepositoryDb.getTasksByProjectID(project_id);
    }

    public Project getProjectByID(int project_id) {
        return iProjectManagerRepositoryDb.getProjectByID(project_id);
    }

    public Subtask createSubtask(Subtask subtask, int taskID) {
        return iProjectManagerRepositoryDb.createSubtask(subtask, taskID);
    }

    public List<Subtask> getSubtasks(int taskID) {
        return iProjectManagerRepositoryDb.getSubtasks(taskID);
    }
}
