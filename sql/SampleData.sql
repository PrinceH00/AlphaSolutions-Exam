INSERT INTO User (firstname, lastname, email, password)
VALUES ('Hamza', 'Nazzar', 'hamza@example.com', 'pw1'),
       ('Hakan', 'Nazzar', 'hakan@example.com', 'pw2'),
       ('Zana', 'Nazzar', 'zana@example.com', 'pw3'),
       ('Alice', 'Johnson', 'alicejohnson@example.com', 'password4');

INSERT INTO Employee (firstname, lastname, email, role, user_id)
VALUES ('Mo', 'Doe', 'johndoe@example.com', 'Manager', 1),
       ('Mango', 'Doe', 'janedoe@example.com', 'Developer', 1),
       ('Bob', 'Smith', 'bobsmith@example.com', 'Designer', 2),
       ('Alice', 'Johnson', 'alicejohnson@example.com', 'Developer', 3);

INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, isDone, user_id)
VALUES ('ProjectManager', 'Make an ProjectManager application', '2023-01-01', '2023-02-01', '2022-02-02', 1, 1),
       ('ProjectManager', 'Make an ProjectManager application', '2023-01-01', '2023-03-01', NULL, 0, 2),
       ('ProjectManager', 'Make an ProjectManager application', '2023-01-01', '2023-04-01', NULL, 0, 3);

INSERT INTO Task (title, description, isDone, project_id)
VALUES ('Task 1', 'This is the first task', 0, 1),
       ('Task 2', 'This is the second task', 0, 1),
       ('Task 3', 'This is the third task', 1, 2),
       ('Task 4', 'This is the fourth task', 0, 3);

INSERT INTO Subtask (title, description, estimated_time, final_time, isDone, task_id)
VALUES ('Subtask 1', 'This is the first subtask', 10, NULL, 0, 1),
       ('Subtask 2', 'This is the second subtask', 5, 4, 1, 1),
       ('Subtask 3', 'This is the third subtask', 8, 6, 1, 2),
       ('Subtask 4', 'This is the fourth subtask', 12, 12, 1, 2),
       ('Subtask 5', 'This is the fifth subtask', 3, NULL, 0, 3);

INSERT INTO EmployeeTask (employee_id, task_id)
VALUES (2, 1),
       (2, 2),
       (4, 3);

INSERT INTO EmployeeSubtask (employee_id, subtask_id)
VALUES (2, 1),
       (2, 2),
       (4, 3),
       (4, 4);