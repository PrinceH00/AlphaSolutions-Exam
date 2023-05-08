package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.Task;
import nazzr.alphasolutionsexam.model.User;

import java.util.List;

public interface IProjectManagerRepository_DB {

    Project createProject(Project project);
    List<Project> getAllProjects(User user);
    Task createTask (Task task);
    List <Task> getAllTask (Project project);
}
