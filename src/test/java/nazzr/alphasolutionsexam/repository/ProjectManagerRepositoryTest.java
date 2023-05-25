package nazzr.alphasolutionsexam.repository;

import nazzr.alphasolutionsexam.dto.ProjectTimeDTO;
import nazzr.alphasolutionsexam.dto.SubtaskDTO;
import nazzr.alphasolutionsexam.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProjectManagerRepositoryTest {

    @Autowired
    private ProjectManagerRepository_DB repository;

    @Test
    public void testCreateProject() {
        Project project = new Project();
        project.setTitle("Test Project");
        project.setDescription("This is a test project");
        project.setStartDate(LocalDate.now());
        project.setDeadlineDate(LocalDate.now().plusDays(7));
        project.setFinalDate(null);
        project.setUserID(1);

        Project createdProject = repository.createProject(project);

        Assertions.assertNotNull(createdProject);
        Assertions.assertEquals(project.getTitle(), createdProject.getTitle());
        Assertions.assertEquals(project.getDescription(), createdProject.getDescription());
        Assertions.assertEquals(project.getStartDate(), createdProject.getStartDate());
        Assertions.assertEquals(project.getDeadlineDate(), createdProject.getDeadlineDate());
        Assertions.assertEquals(project.getFinalDate(), createdProject.getFinalDate());
        Assertions.assertEquals(project.getUserID(), createdProject.getUserID());
    }

    @Test
    public void testGetProjectByID() {
        int projectID = 1;

        Project project = repository.getProjectByID(projectID);

        Assertions.assertNotNull(project);
        Assertions.assertEquals(projectID, project.getProjectID());
    }

    @Test
    public void testGetProjects() {
        User user = new User();
        user.setUserID(1);

        List<ProjectTimeDTO> projects = repository.getProjects(user);

        Assertions.assertNotNull(projects);
    }

    @Test
    public void testDeleteProject() {
        int projectID = 1;

        repository.deleteProject(projectID);
    }

    @Test
    public void testUpdateProject() {
        int projectID = 1;

        Project project = repository.getProjectByID(projectID);
        Assertions.assertNotNull(project);

        project.setTitle("Updated Project Title");

        repository.updateProject(project);

        Project updatedProject = repository.getProjectByID(projectID);

        Assertions.assertNotNull(updatedProject);
        Assertions.assertEquals(project.getTitle(), updatedProject.getTitle());

    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setJob("Developer");
        employee.setUserID(1);

        Employee createdEmployee = repository.createEmployee(employee);

        Assertions.assertNotNull(createdEmployee);
        Assertions.assertEquals(employee.getFirstName(), createdEmployee.getFirstName());
        Assertions.assertEquals(employee.getLastName(), createdEmployee.getLastName());
        Assertions.assertEquals(employee.getEmail(), createdEmployee.getEmail());
        Assertions.assertEquals(employee.getJob(), createdEmployee.getJob());
        Assertions.assertEquals(employee.getUserID(), createdEmployee.getUserID());
    }

    @Test
    public void testGetEmployeeByID() {
        int employeeID = 1;

        Employee employee = repository.getEmployeeByID(employeeID);

        Assertions.assertNotNull(employee);
        Assertions.assertEquals(employeeID, employee.getEmployeeID());
    }

    @Test
    public void testGetEmployees() {
        User user = new User();
        user.setUserID(1);

        List<Employee> employees = repository.getEmployees(user);

        Assertions.assertNotNull(employees);
    }

    @Test
    public void testUpdateEmployee() {
        int employeeID = 1;

        Employee employee = repository.getEmployeeByID(employeeID);
        Assertions.assertNotNull(employee);

        employee.setFirstName("Updated First Name");
        employee.setLastName("Updated Last Name");
        employee.setEmail("updated.email@example.com");
        employee.setJob("Updated Job");

        repository.updateEmployee(employee);

        Employee updatedEmployee = repository.getEmployeeByID(employeeID);

        Assertions.assertNotNull(updatedEmployee);
        Assertions.assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        Assertions.assertEquals(employee.getLastName(), updatedEmployee.getLastName());
        Assertions.assertEquals(employee.getEmail(), updatedEmployee.getEmail());
        Assertions.assertEquals(employee.getJob(), updatedEmployee.getJob());
    }

    @Test
    public void testDeleteEmployee() {
        int employeeID = 1;

        repository.deleteEmployee(employeeID);
    }

    @Test
    public void testCreateTask() {
        int projectID = 1;

        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Task description");
        task.setProjectID(projectID);

        Task createdTask = repository.createTask(task, projectID);

        Assertions.assertNotNull(createdTask);
        Assertions.assertNotEquals(0, createdTask.getTaskID());
        Assertions.assertEquals(task.getTitle(), createdTask.getTitle());
        Assertions.assertEquals(task.getDescription(), createdTask.getDescription());
        Assertions.assertEquals(task.getProjectID(), createdTask.getProjectID());
    }

    @Test
    public void testGetTaskByID() {
        int taskID = 1;

        Task task = repository.getTaskByID(taskID);

        Assertions.assertNotNull(task);
        Assertions.assertEquals(taskID, task.getTaskID());
    }

    @Test
    public void testGetTasks() {
        int projectID = 1;

        List<Task> tasks = repository.getTasks(projectID);

        Assertions.assertNotNull(tasks);
    }

    @Test
    public void testUpdateTask() {
        int taskID = 1;

        Task task = repository.getTaskByID(taskID);
        Assertions.assertNotNull(task);

        task.setTitle("Updated Task Title");
        task.setDescription("Updated Task Description");

        repository.updateTask(task);

        Task updatedTask = repository.getTaskByID(taskID);

        Assertions.assertNotNull(updatedTask);
        Assertions.assertEquals(task.getTitle(), updatedTask.getTitle());
        Assertions.assertEquals(task.getDescription(), updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        int taskID = 1;

        repository.deleteTask(taskID);
    }

    //--------------------------------------------------SUBTASK-------------------------------------------------------\\

    @Test
    public void testCreateSubtask() {
        int taskID = 1;

        Subtask subtask = new Subtask();
        subtask.setTitle("Subtask 1");
        subtask.setDescription("Subtask description");
        subtask.setEstimated_time(5);
        subtask.setFinal_time(0);

        List<Integer> assignedEmployeeIDs = new ArrayList<>();
        assignedEmployeeIDs.add(1);
        assignedEmployeeIDs.add(2);

        repository.createSubtask(subtask, taskID, assignedEmployeeIDs);

        Assertions.assertNotEquals(0, subtask.getSubtaskID());
        Assertions.assertEquals("Subtask 1", subtask.getTitle());
        Assertions.assertEquals("Subtask description", subtask.getDescription());
        Assertions.assertEquals(5, subtask.getEstimated_time());
        Assertions.assertEquals(0, subtask.getFinal_time());
        Assertions.assertFalse(subtask.isDone());

        List<Integer> retrievedAssignedEmployeeIDs = repository.getAssignedEmployeeIDs(subtask.getSubtaskID());
        Assertions.assertEquals(2, retrievedAssignedEmployeeIDs.size());
        Assertions.assertTrue(retrievedAssignedEmployeeIDs.contains(1));
        Assertions.assertTrue(retrievedAssignedEmployeeIDs.contains(2));
    }

    @Test
    public void testGetSubtaskByID() {
        int subtaskID = 1;

        Subtask subtask = repository.getSubTaskByID(subtaskID);

        Assertions.assertNotNull(subtask);
        Assertions.assertEquals(subtaskID, subtask.getSubtaskID());
    }

    @Test
    public void testGetSubtasks() {
        int taskID = 1;

        List<SubtaskDTO> subtasks = repository.getSubtasks(taskID);

        Assertions.assertNotNull(subtasks);
    }

    @Test
    public void testUpdateSubtask() {
        int subtaskID = 1;

        Subtask subtask = repository.getSubTaskByID(subtaskID);
        Assertions.assertNotNull(subtask);

        subtask.setTitle("Updated Subtask Title");
        subtask.setDescription("Updated Subtask Description");
        subtask.setEstimated_time(8);
        subtask.setFinal_time(4);
        subtask.setDone(true);

        List<Integer> assignedEmployeeIDs = new ArrayList<>();
        assignedEmployeeIDs.add(3);

        repository.updateSubtask(subtask, assignedEmployeeIDs);

        Subtask updatedSubtask = repository.getSubTaskByID(subtaskID);

        Assertions.assertNotNull(updatedSubtask);
        Assertions.assertEquals(subtask.getTitle(), updatedSubtask.getTitle());
        Assertions.assertEquals(subtask.getDescription(), updatedSubtask.getDescription());
        Assertions.assertEquals(subtask.getEstimated_time(), updatedSubtask.getEstimated_time());
        Assertions.assertEquals(subtask.getFinal_time(), updatedSubtask.getFinal_time());
        Assertions.assertEquals(subtask.isDone(), updatedSubtask.isDone());

        List<Integer> retrievedAssignedEmployeeIDs = repository.getAssignedEmployeeIDs(subtaskID);
        Assertions.assertEquals(1, retrievedAssignedEmployeeIDs.size());
        Assertions.assertTrue(retrievedAssignedEmployeeIDs.contains(3));
    }

    @Test
    public void testDeleteSubtask() {
        int subtaskID = 1;

        repository.deleteSubtask(subtaskID);
    }
}
