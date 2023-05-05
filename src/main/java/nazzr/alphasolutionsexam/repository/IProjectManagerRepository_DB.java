package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.DTO.ViewProjectDTO;
import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.User;

import java.util.List;

public interface IProjectManagerRepository_DB {

    Project createProject(Project project);

    public List<ViewProjectDTO> getAllProjects(User user);
}
