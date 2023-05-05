package nazzr.alphasolutionsexam.service;

import nazzr.alphasolutionsexam.model.Project;
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
    public List<Project> getAllProjects(){
        return iProjectManagerRepositoryDb.getAllProjects();
    }
}
