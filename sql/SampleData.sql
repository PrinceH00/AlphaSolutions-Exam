-- Sample Users
INSERT INTO User (firstname, lastname, email, password)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password'),
       ('Jane', 'Doe', 'jane.doe@example.com', 'password'),
       ('Bob', 'Smith', 'bob.smith@example.com', 'password');

-- Sample Employees
INSERT INTO Employee (firstname, lastname, email, role, user_id)
VALUES ('Emily', 'Johnson', 'emily.johnson@example.com', 'Project Manager', 1),
       ('Michael', 'Davis', 'michael.davis@example.com', 'Developer', 2),
       ('Sarah', 'Wilson', 'sarah.wilson@example.com', 'QA Tester', 3);

-- Sample Projects
INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, isDone, user_id)
VALUES ('Project A', 'Lorem ipsum dolor sit amet.', '2023-05-01', '2023-06-30', NULL, 0, 1),
       ('Project B', 'Lorem ipsum dolor sit amet.', '2023-06-01', '2023-08-31', NULL, 0, 1),
       ('Project C', 'Lorem ipsum dolor sit amet.', '2023-07-01', '2023-09-30', NULL, 0, 2);

-- Sample Tasks
INSERT INTO Task (title, description, isDone, project_id)
VALUES ('Task 1', 'Lorem ipsum dolor sit amet.', 0, 1),
       ('Task 2', 'Lorem ipsum dolor sit amet.', 0, 1),
       ('Task 3', 'Lorem ipsum dolor sit amet.', 0, 2),
       ('Task 4', 'Lorem ipsum dolor sit amet.', 0, 2),
       ('Task 5', 'Lorem ipsum dolor sit amet.', 0, 3);

-- Sample Subtasks
INSERT INTO Subtask (title, description, estimated_time, final_time, isDone, task_id)
VALUES ('Subtask 1', 'Lorem ipsum dolor sit amet.', 10, NULL, 0, 1),
       ('Subtask 2', 'Lorem ipsum dolor sit amet.', 5, NULL, 0, 1),
       ('Subtask 3', 'Lorem ipsum dolor sit amet.', 8, NULL, 0, 2),
       ('Subtask 4', 'Lorem ipsum dolor sit amet.', 6, NULL, 0, 2),
       ('Subtask 5', 'Lorem ipsum dolor sit amet.', 4, NULL, 0, 3),
       ('Subtask 6', 'Lorem ipsum dolor sit amet.', 4, NULL, 0, 4),
       ('Subtask 7', 'Lorem ipsum dolor sit amet.', 6, NULL, 0, 5);

-- Sample EmployeeSubtasks
INSERT INTO EmployeeSubtask (employee_id, subtask_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (3, 7);
