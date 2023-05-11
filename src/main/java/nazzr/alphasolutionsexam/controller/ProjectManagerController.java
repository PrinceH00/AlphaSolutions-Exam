package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.model.*;
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

    //------------------------------------------------PROJECT-----------------------------------------------------\\
    @GetMapping("create_project")
    public String createProject(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Project project = new Project();
            model.addAttribute("project", project);
            return "create_project";
        }
        return "redirect:/login";
    }

    @PostMapping("create_project")
    public String saveProject(@ModelAttribute("project") Project project, HttpSession session) {
        if (isLoggedIn(session)) {
            User user = (User) session.getAttribute("user");
            project.setUserID(user.getUserID());
            projectManagerService.createProject(project);
            return "redirect:dashboard";

        }
        return "redirect:/login";
    }

    @PostMapping("delete_project/{project_id}")
    public String deleteProject(@PathVariable int project_id, HttpSession session) {
        if (isLoggedIn(session)) {
            projectManagerService.deleteProject(project_id);
            return "redirect:/dashboard";
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
    //------------------------------------------------EMPLOYEES-----------------------------------------------------\\
    @GetMapping("create_employee")
    public String createEmployee(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Employee employee = new Employee();
            model.addAttribute("employee", employee);
            return "create_employee";
        }
        return "redirect:/login";
    }

    @PostMapping("create_employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, HttpSession session) {
        if (isLoggedIn(session)) {
            User user = (User) session.getAttribute("user");
            employee.setUserID(user.getUserID());
            projectManagerService.createEmployee(employee);
            return "redirect:dashboard";

        }
        return "redirect:/login";
    }

    @GetMapping("employees")
    public String viewEmployee(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            List<Employee> employees = projectManagerService.getEmployees((User) session.getAttribute("user"));
            model.addAttribute("employees", employees);
            return "employees";
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
            projectManagerService.createTask(task, project_id);
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("task/{project_id}")
    public String getAllTask(HttpSession session, Model model, @PathVariable int project_id) {
        if (isLoggedIn(session)) {
            List<Task> taskList = projectManagerService.getAllTask(project_id);
            model.addAttribute("task", taskList);
            return "task";
        }
        return "redirect:/login";
    }

    //------------------------------------------------SUBTASKS-----------------------------------------------------\\
    @GetMapping("create_subtask/{taskID}")
    public String createSubtask(@PathVariable int taskID, Model model, HttpSession session) {
        if (isLoggedIn(session)) {
            Subtask subtask = new Subtask();
            subtask.setTaskID(taskID);
            model.addAttribute("subtask", subtask);
            return "create_subtask";
        }
        return "redirect:/login";
    }

    @PostMapping("create_subtask/{taskID}")
    public String saveSubtask(@PathVariable int taskID, @ModelAttribute Subtask subtask, HttpSession session) {
        if (isLoggedIn(session)) {
            subtask.setTaskID(taskID);
            projectManagerService.createSubtask(subtask, taskID);
            return "redirect:/subtasks/" + taskID;
        }
        return "redirect:/login";
    }

    @GetMapping("subtasks/{taskID}")
    public String getSubtasks(@PathVariable int taskID, Model model, HttpSession session) {
        if (isLoggedIn(session)) {
            List<Subtask> subtasks = projectManagerService.getSubtasks(taskID);
            model.addAttribute("subtasks", subtasks);
            return "subtasks";
        }
        return "redirect:/login";
    }
}
