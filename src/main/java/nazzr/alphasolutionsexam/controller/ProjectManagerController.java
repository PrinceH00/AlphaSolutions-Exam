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

    @PostMapping("delete_project/{projectID}")
    public String deleteProject(@PathVariable int projectID, HttpSession session) {
        if (isLoggedIn(session)) {
            projectManagerService.deleteProject(projectID);
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("edit_project/{projectID}")
    public String editProject(@PathVariable int projectID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Project project = projectManagerService.getProjectByID(projectID);
            model.addAttribute("project", project);

            return "edit_project";
        }
        return "redirect:/login";
    }

    @PostMapping("edit_project/{projectID}")
    public String updateProject(@PathVariable int projectID, @ModelAttribute("project") Project project, HttpSession session) {
        if (isLoggedIn(session)) {
            project.setProjectID(projectID);
            projectManagerService.updateProject(project);

            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }


    @GetMapping("dashboard")
    public String viewProjects(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            List<Project> projectList = projectManagerService.getProjects((User) session.getAttribute("user"));
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

            return "redirect:employees";

        }
        return "redirect:/login";
    }

    @GetMapping("employees")
    public String viewEmployees(HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            List<Employee> employees = projectManagerService.getEmployees((User) session.getAttribute("user"));
            model.addAttribute("employees", employees);

            return "employees";
        }
        return "redirect:/login";
    }

    @PostMapping("delete_employee/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID, HttpSession session) {
        if (isLoggedIn(session)) {
            projectManagerService.deleteEmployee(employeeID);

            return "redirect:/employees";
        }
        return "redirect:/login";
    }

    //-------------------------------------------------TASK-------------------------------------------------------\\
    @GetMapping("create_task/{projectID}")
    public String createTask(@PathVariable int projectID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Task task = new Task();
            task.setProjectID(projectID);
            model.addAttribute("task", task);

            return "create_task";
        }
        return "redirect:/login";
    }

    @PostMapping("create_task/{projectID}")
    public String saveTask( @PathVariable int projectID, @ModelAttribute Task task, HttpSession session) {
        if (isLoggedIn(session)) {
            task.setProjectID(projectID);
            projectManagerService.createTask(task, projectID);

            return "redirect:/tasks/" + projectID;
        }
        return "redirect:/login";
    }

    @GetMapping("tasks/{projectID}")
    public String viewTasks( @PathVariable int projectID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            List<Task> taskList = projectManagerService.getTasks(projectID);
            model.addAttribute("tasks", taskList);

            return "tasks";
        }
        return "redirect:/login";
    }

    @PostMapping("delete_task/{taskID}")
    public String deleteTask(@PathVariable int taskID, HttpSession session) {
        if (isLoggedIn(session)) {
            Task task = projectManagerService.getTaskByID(taskID);
            int projectID = task.getProjectID();
            projectManagerService.deleteTask(taskID);

            return "redirect:/tasks/" + projectID;
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
    public String viewSubtasks(@PathVariable int taskID, Model model, HttpSession session) {
        if (isLoggedIn(session)) {
            List<Subtask> subtasks = projectManagerService.getSubtasks(taskID);
            model.addAttribute("subtasks", subtasks);

            return "subtasks";
        }
        return "redirect:/login";
    }

    @PostMapping("delete_subtask/{subTaskID}")
    public String deleteSubtask(@PathVariable int subTaskID, HttpSession session) {
        if (isLoggedIn(session)) {
            Subtask subtask = projectManagerService.getSubTaskByID(subTaskID);
            int taskID = subtask.getTaskID();
            projectManagerService.deleteSubtask(subTaskID);

            return "redirect:/subtasks/" + taskID;
        }
        return "redirect:/login";
    }
}
