USE projectmanager;
INSERT INTO User (firstname, lastname, email, password)
VALUES
    ('John', 'Doe', 'johndoe@example.com', 'password123'),
    ('Jane', 'Smith', 'janesmith@example.com', 'pass123word'),
    ('Michael', 'Johnson', 'michaeljohnson@example.com', 'securepassword');

INSERT INTO Employee (firstname, lastname, email, job, user_id)
VALUES
    ('John', 'Doe', 'johndoe@example.com', 'Project Manager', 1),
    ('Jane', 'Smith', 'janesmith@example.com', 'Developer', 2),
    ('Michael', 'Johnson', 'michaeljohnson@example.com', 'Designer', 3);

INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, user_id)
VALUES
    ('Project A', 'This is the description for Project A.', '2023-01-01', '2023-03-31', NULL, 1),
    ('Project B', 'This is the description for Project B.', '2023-02-15', '2023-05-31', NULL, 1),
    ('Project C', 'This is the description for Project C.', '2023-03-10', '2023-06-30', NULL, 2);

INSERT INTO Task (title, description, project_id)
VALUES
    ('Task 1', 'This is the description for Task 1 in Project A.', 1),
    ('Task 2', 'This is the description for Task 2 in Project A.', 1),
    ('Task 3', 'This is the description for Task 3 in Project B.', 2),
    ('Task 4', 'This is the description for Task 4 in Project C.', 3);

INSERT INTO Subtask (title, description, estimated_time, final_time, task_id)
VALUES
    ('Subtask 1', 'This is the description for Subtask 1 in Task 1.', 10, NULL, 1),
    ('Subtask 2', 'This is the description for Subtask 2 in Task 1.', 5, NULL, 1),
    ('Subtask 3', 'This is the description for Subtask 3 in Task 2.', 8, NULL, 2),
    ('Subtask 4', 'This is the description for Subtask 4 in Task 3.', 12, NULL, 3),
    ('Subtask 5', 'This is the description for Subtask 5 in Task 3.', 6, NULL, 3),
    ('Subtask 6', 'This is the description for Subtask 6 in Task 4.', 15, NULL, 4);

INSERT INTO EmployeeSubtask (employee_id, subtask_id)
VALUES
    (2, 1),
    (2, 2),
    (3, 3),
    (1, 4),
    (1, 5),
    (3, 6);
