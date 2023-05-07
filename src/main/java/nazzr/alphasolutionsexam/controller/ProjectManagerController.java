    package nazzr.alphasolutionsexam.controller;

    import jakarta.servlet.http.HttpSession;
    import nazzr.alphasolutionsexam.model.Project;
    import nazzr.alphasolutionsexam.model.Task;
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
    @RequestMapping("/")
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
        @GetMapping("create_project")
        public String createProject(HttpSession session, Model model) {
            if(isLoggedIn(session)) {
                Project project = new Project();
                model.addAttribute("project", project);
                return "create_project";
            }
           return "redirect:/login";
        }

        @PostMapping("create_project")
        public String saveProject(@ModelAttribute("project") Project project, HttpSession session) {
           if(isLoggedIn(session)) {
            User user = (User) session.getAttribute("user");
            project.setUserID(user.getUserID());
            projectManagerService.createProject(project);
            return "redirect:dashboard";

            }
            return "redirect:/login";
        }

        @GetMapping("dashboard")
        public String viewProject(HttpSession session, Model model) {
            if (isLoggedIn(session)) {
                List<Project> projectList = projectManagerService.getAllProjects((User) session.getAttribute("user"));
                model.addAttribute("projectList", projectList);
                return "dashboard";
            }
            return "redirect:/login";
        }

        @GetMapping("create_task")
        public String createTask(HttpSession session, Model model) {
            if (isLoggedIn(session)) {
                Task task = new Task();
                model.addAttribute("task", task);
                return "create_task";
            }
            return "redirect:/login";
        }
        @PostMapping("create_task")
        public String createTask(@ModelAttribute Task task, HttpSession session){
            if (isLoggedIn(session)){
                Project project = (Project) session.getAttribute("project");
                task.setProjectID(project.getProjectID());
                projectManagerService.createTask(task);
                return "redirect:/project";
            }
            return "redirect:/login";
        }
    }
