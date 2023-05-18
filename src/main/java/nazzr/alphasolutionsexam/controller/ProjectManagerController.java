package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.dto.SubtaskDTO;
import nazzr.alphasolutionsexam.model.*;
import nazzr.alphasolutionsexam.service.ProjectManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
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

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String startDateString = project.getStartDate().format(dateFormatter);
            String deadlineDateString = project.getDeadlineDate().format(dateFormatter);
            String finalDateString = "";
            if (project.getFinalDate() != null) {
                finalDateString = project.getFinalDate().format(dateFormatter);
            }

            model.addAttribute("startDateString", startDateString);
            model.addAttribute("deadlineDateString", deadlineDateString);
            model.addAttribute("finalDateString", finalDateString);
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

    @GetMapping("edit_employee/{employeeID}")
    public String editEmployee(@PathVariable int employeeID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Employee employee = projectManagerService.getEmployeeByID(employeeID);
            model.addAttribute("employee", employee);

            return "edit_employee";
        }
        return "redirect:/login";
    }

    @PostMapping("edit_employee/{employeeID}")
    public String updateEmployee(@PathVariable int employeeID, @ModelAttribute("employee") Employee employee, HttpSession session) {
        if (isLoggedIn(session)) {
            employee.setEmployeeID(employeeID);
            projectManagerService.updateEmployee(employee);

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
    @GetMapping("edit_task/{taskID}")
    public String editTask(@PathVariable int taskID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Task task = projectManagerService.getTaskByID(taskID);
            model.addAttribute("task", task);
            return "edit_task";
        }
        return "redirect:/login";
    }
    @PostMapping("edit_task/{taskID}")
    public String updateTask(@PathVariable int taskID, @ModelAttribute("task") Task task, HttpSession session) {
        if (isLoggedIn(session)) {
            task.setTaskID(taskID);
            int projectID = projectManagerService.getTaskByID(taskID).getProjectID();
            projectManagerService.updateTask(task);

            return "redirect:/tasks/" + projectID;
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
            List<SubtaskDTO> subtasks = projectManagerService.getSubtasks(taskID);
            model.addAttribute("subtasks", subtasks);

            return "subtasks";
        }
        return "redirect:/login";
    }
    @GetMapping("edit_subtask/{subtaskID}")
    public String editSubtask(@PathVariable int subtaskID, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            Subtask subtask = projectManagerService.getSubTaskByID(subtaskID);
            model.addAttribute("subtask", subtask);
            return "edit_subtask";
        }
        return "redirect:/login";
    }
    @PostMapping("edit_subtask/{subtaskID}")
    public String updateSubtask(@PathVariable int subtaskID, @ModelAttribute("subtask") Subtask subtask, HttpSession session) {
        if (isLoggedIn(session)) {
            subtask.setSubtaskID(subtaskID);
            int taskID = projectManagerService.getSubTaskByID(subtaskID).getTaskID();
            projectManagerService.updateSubtask(subtask);
            return "redirect:/subtasks/" + taskID;
        }
        return "redirect:/login";
    }
    @PostMapping("/mark_done/{subtaskID}")
    public String markSubtaskAsDone(@PathVariable("subtaskID") int subtaskID, HttpSession session) {
        if (isLoggedIn(session)) {
            Subtask subtask = projectManagerService.getSubTaskByID(subtaskID);
            int taskID = subtask.getTaskID();
            if (subtask != null) {
                boolean isDone = !subtask.isDone();
                subtask.setDone(isDone);
                projectManagerService.updateSubtaskStatus(subtaskID,isDone);
            }
            return "redirect:/subtasks/" + taskID;
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
