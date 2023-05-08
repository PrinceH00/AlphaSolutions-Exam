package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.Subtask;
import nazzr.alphasolutionsexam.model.Task;
import nazzr.alphasolutionsexam.model.User;

import java.util.List;

public interface IProjectManagerRepository_DB {

    Project createProject(Project project);
    public Project getProjectByID(int project_id);
    List<Project> getAllProjects(User user);
    Task createTask (Task task, int project_id);
    List <Task> getTasksByProjectID(int project_id);
    Subtask createSubtask(Subtask subtask);
    List<Subtask> getAllSubtask(Task task);

}
