USE projectmanager;

INSERT INTO User (firstname, lastname, email, password)
VALUES ('John', 'Doe', 'johndoe@example.com', 'password123'),
       ('Jane', 'Smith', 'janesmith@example.com', 'letmein'),
       ('Bob', 'Johnson', 'bobjohnson@example.com', 'test123');

INSERT INTO Employee (firstname, lastname, email, role, user_id)
VALUES ('John', 'Doe', 'johndoe@example.com', 'Project Manager', 1),
       ('Jane', 'Smith', 'janesmith@example.com', 'Developer', 2),
       ('Bob', 'Johnson', 'bobjohnson@example.com', 'Designer', 3);

INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, isDone, user_id)
VALUES ('Website Redesign', 'Redesign of company website', '2023-01-01', '2023-03-31', NULL, 0, 1),
       ('Mobile App Development', 'Development of a new mobile app', '2023-02-01', '2023-06-30', NULL, 0, 1);

INSERT INTO Task (title, description, isDone, project_id)
VALUES ('Design Wireframes', 'Create wireframes for website redesign', 0, 1),
       ('Develop Backend', 'Develop the backend for the mobile app', 0, 2),
       ('Create Marketing Materials', 'Create marketing materials for website redesign', 0, 1);

INSERT INTO Subtask (title, description, estimated_time, final_time, isDone, task_id)
VALUES ('Homepage Wireframe', 'Create wireframe for the homepage', 8, NULL, 0, 1),
       ('API Development', 'Develop API for the mobile app', 40, NULL, 0, 2),
       ('Logo Design', 'Design a new logo for the company', 6, NULL, 0, 3);

INSERT INTO EmployeeSubtask (employee_id, subtask_id)
VALUES (2, 1),
       (3, 3),
       (1, 2);