## AlphaSolutions-Exam

This project is our second semester exam-project. This application will help you manage your projects and give you an
overview over the project, employees, tasks and subtasks.

While the application is running the following end-points are valid:

* **End-point**/login
* **End-point**/signup
* **End-point**/dashboard
* **End-point**/create_project

And many more but these are the essential endpoints.

--- 

### **Homepage**

Our Project Manager application greets you with a login page where u can **sign up or login**.
To log in the user are required to have or give an **Email and a password**.
To sign up it is also required to have **Firstname and Lastname**

After logging in the user will be directed to Dashboard where all the projects are displayed, here he/she has 4 options.

1. Create, Edit and Delete a project.
2. Access tasks for a project.
3. View employees.
4. logout.

###

#### **Create Project**

When the user wants to create a new Project they simply need to tap **Add project** and be redirected to a page where
the need to fill out the required fields.

After entering the title, description, startDate and deadline the user will have successfully created a project and the
newly created project will then be viewed on the dashboard.

The Subtask looks like this:

| Project Title          | Start Date                | (Deadline Date)           | Final Date              | Total Estimated Time                       | Total Final Time                                | Time Evaluation                                                |
|------------------------|---------------------------|---------------------------|-------------------------|--------------------------------------------|-------------------------------------------------|----------------------------------------------------------------|
| (Title of the project) | (When the project starts) | (When is need to be done) | (When it was delivered) | (Total time for all subtask for all tasks) | (Total time used for all subtask for all tasks) | (If the estimated time was the same or lower then finail time) |        

###

#### **View employees**

when viewing the employees the user can add new employees by tapping **Add employee** and be redirected to a form and
has the option to **Edit** and **delete** or simply go back to dashboard.

The Employees will look like this:

| FirstName            | LastName            | Email   | Job                  |
|----------------------|---------------------|---------|----------------------|
| (employee firstName) | (employee lastName) | (Email) | (allocated position) |   

###

#### **View tasks**

To access the tasks in a specific project, the user simply needs to tap **Tasks**.
When tapped the user also get the option to **Add a task** to the project or go further into subtask.

Tasks also have the same functions as before as **Delete, Edit or logout**

The Tasks will look like this:

| Title        | Description        |
|--------------|--------------------|
| (Title name) | (task description) |        

###

#### **View Subtasks**

Subtasks are accessed by a specific task to allocate the task into smaller bites witch will in turn make the task easier
to complete.

Subtask will mostly have the same functionality and Task and Project, the difference will be that Subtasks kan be **
Marked as done** and can have employees **assigned** to them.

The Subtask looks like this:

| Title        | Description           | Estimated time            | Final time                   | Assigned Employees           |
|--------------|-----------------------|---------------------------|------------------------------|------------------------------|
| (Title name) | (Subtask description) | (Time estimated to solve) | (how long it took to finish) | (Which employee is assigned) |        


