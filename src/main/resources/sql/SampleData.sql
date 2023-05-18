INSERT INTO User (firstname, lastname, email, password) VALUES
     ('John', 'Doe', 'john.doe@example.com', 'password123'),
     ('Jane', 'Smith', 'jane.smith@example.com', 'password456');

INSERT INTO Employee (firstname, lastname, email, job, user_id) VALUES
 ('David', 'Johnson', 'david.johnson@example.com', 'Developer', 1),
 ('Emily', 'Brown', 'emily.brown@example.com', 'Designer', 2);

INSERT INTO Project (title, description, startDate, deadlineDate, finalDate, user_id) VALUES
 ('Project A', 'Sample project A', '2023-01-01', '2023-02-01', '2023-01-30', 1),
 ('Project B', 'Sample project B', '2023-02-01', '2023-03-01', NULL, 2);

INSERT INTO Task (title, description, project_id) VALUES
 ('Task A1', 'Sample task A1', 1),
 ('Task A2', 'Sample task A2', 1),
 ('Task B1', 'Sample task B1', 2);

INSERT INTO Subtask (title, description, estimated_time, final_time, isDone, task_id) VALUES
 ('Subtask A1.1', 'Sample subtask A1.1', 4, 2, 1, 1),
 ('Subtask A1.2', 'Sample subtask A1.2', 6, NULL, 0, 1),
 ('Subtask A2.1', 'Sample subtask A2.1', 8, NULL, 0, 2);

INSERT INTO EmployeeSubtask (employee_id, subtask_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (2, 3);
