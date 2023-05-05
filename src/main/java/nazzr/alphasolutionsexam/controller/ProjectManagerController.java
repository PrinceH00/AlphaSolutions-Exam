package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.DTO.ViewProjectDTO;
import nazzr.alphasolutionsexam.model.Project;
import nazzr.alphasolutionsexam.model.User;
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
        return "home_page";
    }


    //--------------------------------------------------Project-----------------------------------------------------\\
    @GetMapping("/project")
    public String createProject(HttpSession session, Model model) {
        if(isLoggedIn(session)) {
            model.addAttribute("project", new Project());
            return "create_project";
        }
        return "redirect:/login";
    }

    @PostMapping("/project")
    public String saveProject(@ModelAttribute Project project, Model model, HttpSession session) {
        if(isLoggedIn(session)) {
        model.addAttribute("project", project);
        projectManagerService.createProject(project);
        return "redirect:/dashboard";

        }
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String viewProject(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            List<ViewProjectDTO> projectList = projectManagerService.getAllProjects((User) session.getAttribute("user"));
            model.addAttribute("projects", projectList);
            return "dashboard";
        }
        return "redirect:/login";
    }
}
