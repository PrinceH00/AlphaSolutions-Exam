    package nazzr.alphasolutionsexam.controller;

    import jakarta.servlet.http.HttpSession;
    import nazzr.alphasolutionsexam.model.Project;
    import nazzr.alphasolutionsexam.model.Subtask;
    import nazzr.alphasolutionsexam.model.Task;
    import nazzr.alphasolutionsexam.model.User;
    import nazzr.alphasolutionsexam.service.ProjectManagerService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
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


        //------------------------------------------------PROJECT-----------------------------------------------------\\
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
        //-------------------------------------------------TASK-------------------------------------------------------\\
        @GetMapping("create_task/{project_id}")
        public String createTask(HttpSession session, Model model, @PathVariable int project_id) {
            if (isLoggedIn(session)) {
                Task task = new Task();
                task.setProjectID(project_id);
                model.addAttribute("task", task);
                return "create_task";
            }
            return "redirect:/login";
        }

       @PostMapping("create_task/{project_id}")
        public String saveTask(@ModelAttribute Task task, HttpSession session, @PathVariable int project_id) {
           if (isLoggedIn(session)) {
               task.setProjectID(project_id);
               projectManagerService.createTask(task,project_id);
               return "redirect:/dashboard";
           }
           return "redirect:/login";
       }

           @GetMapping("task/{project_id}")
        public String getAllTask(HttpSession session, Model model, @PathVariable int project_id){
            if (isLoggedIn(session)){
                List<Task> taskList = projectManagerService.getAllTask(project_id);
                model.addAttribute("task", taskList);
                return "task";
            }
            return "redirect:/login";
       }
       //------------------------------------------------SUBTASKS-----------------------------------------------------\\
        @GetMapping("create_subtask/{taskID}")
        public String createSubtask(@PathVariable int taskID, @ModelAttribute("subtask") Model model, HttpSession session) {
            if (isLoggedIn(session)) {
                Subtask subtask = new Subtask();
                subtask.setTaskID(taskID);
                return "create_subtask";
            }
            return "redirect:/login";
        }

        @PostMapping("create_subtask/{taskID}")
        public String saveSubtask(@PathVariable int taskID, @ModelAttribute Subtask subtask, HttpSession session) {
            if (isLoggedIn(session)) {
                subtask.setTaskID(taskID);
                projectManagerService.createSuptask(subtask,taskID);
                return "redirect:/dashboard";
            }
            return "redirect:/login";
        }
    }
