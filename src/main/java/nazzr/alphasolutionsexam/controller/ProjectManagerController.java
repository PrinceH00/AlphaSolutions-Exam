package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.service.ProjectManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ProjectManagerController {

    private final ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    @GetMapping("")
    public String homePage() {
        return "homepage";
    }

    //--------------------------------------------------Project-----------------------------------------------------\\
    @GetMapping("/project")
    public String createProject(Model model) {
        model.addAttribute("project", new Project());
        return "createProject";
    }

    @PostMapping("/project")
    public String saveProject(@ModelAttribute Project project, Model model) {
        model.addAttribute("project", project);
        projectManagerService.createProject(project);
        return "redirect:/dashboard";
    }
    @GetMapping("/project/list")
    public String viewProject(Model model){
        List<Project> projectList = projectManagerService.getAllProjects();
        model.addAttribute("projects", projectList);
        return "dashboard";
    }

}
