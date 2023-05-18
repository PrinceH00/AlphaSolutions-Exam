INSERT INTO User (firstname, lastname, email, password) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123');

INSERT INTO Employee (firstname, lastname, email, job, user_id) VALUES
('Jane', 'Smith', 'jane.smith@example.com', 'Developer', 1),
('Michael', 'Johnson', 'michael.johnson@example.com', 'Designer', 1),
('Emily', 'Davis', 'emily.davis@example.com', 'Tester', 1);

INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, user_id) VALUES
('Project A', 'Description for Project A', '2023-01-01', '2023-06-30', NULL, 1),
('Project B', 'Description for Project B', '2023-02-15', '2023-07-31', NULL, 1),
('Project G', 'Description for Project G', '2023-07-10', '2024-01-31', NULL, 1);

INSERT INTO Task (title, description, project_id) VALUES
('Task 1', 'Description for Task 1', 1),
('Task 2', 'Description for Task 2', 1),
('Task 3', 'Description for Task 3', 2),
('Task 4', 'Description for Task 4', 2),
('Task 5', 'Description for Task 5', 3),
('Task 6', 'Description for Task 6', 3);

INSERT INTO Subtask (title, description, estimated_time, final_time, isDone, task_id) VALUES
('Subtask 1', 'Description for Subtask 1', 10, NULL, 0, 1),
('Subtask 2', 'Description for Subtask 2', 8, NULL, 0, 1),
('Subtask 3', 'Description for Subtask 3', 6, NULL, 0, 2),
('Subtask 4', 'Description for Subtask 4', 4, NULL, 0, 2),
('Subtask 5', 'Description for Subtask 5', 12, NULL, 0, 3),
('Subtask 6', 'Description for Subtask 6', 8, NULL, 0, 3),
('Subtask 7', 'Description for Subtask 7', 6, NULL, 0, 4),
('Subtask 8', 'Description for Subtask 8', 4, NULL, 0, 4),
('Subtask 9', 'Description for Subtask 9', 10, NULL, 0, 5),
('Subtask 10', 'Description for Subtask 10', 8, NULL, 0, 5);

INSERT INTO EmployeeSubtask (employee_id, subtask_id) VALUES
(1, 1), -- Jane Smith is assigned to Subtask 1
(2, 1), -- Michael Johnson is assigned to Subtask 1
(1, 2), -- Jane Smith is assigned to Subtask 2
(3, 2), -- Emily Davis is assigned to Subtask 2
(2, 3), -- Michael Johnson is assigned to Subtask 3
(3, 3), -- Emily Davis is assigned to Subtask 3
(1, 4), -- Jane Smith is assigned to Subtask 4
(2, 4), -- Michael Johnson is assigned to Subtask 4
(3, 5), -- Emily Davis is assigned to Subtask 5
(1, 5), -- Jane Smith is assigned to Subtask 5
(2, 6), -- Michael Johnson is assigned to Subtask 6
(3, 6), -- Emily Davis is assigned to Subtask 6
(1, 7), -- Jane Smith is assigned to Subtask 7
(3, 7), -- Emily Davis is assigned to Subtask 7
(2, 8), -- Michael Johnson is assigned to Subtask 8
(3, 8), -- Emily Davis is assigned to Subtask 8
(1, 9), -- Jane Smith is assigned to Subtask 9
(3, 9), -- Emily Davis is assigned to Subtask 9
(2, 10), -- Michael Johnson is assigned to Subtask 10
(3, 10); -- Emily Davis is assigned to Subtask 10
