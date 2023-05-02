DROP DATABASE IF EXISTS projectmanagerdb;
CREATE DATABASE projectmanagerdb;
USE projectmanagerdb;

CREATE TABLE User
(
    user_id   INT(10) NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(30)  NOT NULL,
    lastname  VARCHAR(30)  NOT NULL,
    email     VARCHAR(100) NOT NULL UNIQUE,
    password  VARCHAR(20)  NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE Employee
(
    employee_id INT(10) NOT NULL AUTO_INCREMENT,
    firstname   VARCHAR(30)  NOT NULL,
    lastname    VARCHAR(30)  NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    role        VARCHAR(30)  NOT NULL,
    user_id     INT(10) NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);

CREATE TABLE Project
(
    project_id   INT(10) NOT NULL AUTO_INCREMENT,
    title        VARCHAR(30) NOT NULL,
    description  VARCHAR(255),
    startDate    DATE        NOT NULL,
    deadlineDate DATE        NOT NULL,
    finalDate    DATE,
    isDone       BIT(1),
    user_id      INT(10) NOT NULL,
    PRIMARY KEY (project_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);

CREATE TABLE Task
(
    task_id     INT(10) NOT NULL AUTO_INCREMENT,
    title       VARCHAR(30) NOT NULL,
    description VARCHAR(255),
    isDone      BIT(1),
    project_id  INT(10) NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (project_id) REFERENCES Project (project_id)
);
CREATE TABLE Subtask
(
    subtask_id     INT(10) NOT NULL AUTO_INCREMENT,
    title          VARCHAR(30) NOT NULL,
    description    VARCHAR(255),
    estimated_time INT(10),
    final_time     INT(10),
    isDone         BIT(1),
    task_id        INT(10) NOT NULL,
    PRIMARY KEY (subtask_id),
    FOREIGN KEY (task_id) REFERENCES Task (task_id)
);

CREATE TABLE EmployeeSubtask
(
    employeesubtask_id INT(10) NOT NULL AUTO_INCREMENT,
    employee_id        INT(10) NOT NULL,
    subtask_id         INT(10) NOT NULL,
    PRIMARY KEY (employeesubtask_id),
    FOREIGN KEY (employee_id) REFERENCES Employee (employee_id),
    FOREIGN KEY (subtask_id) REFERENCES Subtask (subtask_id)
);