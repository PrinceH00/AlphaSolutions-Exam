DROP DATABASE IF EXISTS projectmanager;
CREATE DATABASE projectmanager;
USE projectmanager;

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
    job         VARCHAR(30)  NOT NULL,
    user_id     INT(10) NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Project
(
    project_id   INT(10) NOT NULL AUTO_INCREMENT,
    title        VARCHAR(30) NOT NULL,
    description  VARCHAR(255),
    startDate    DATE        NOT NULL,
    deadlineDate DATE        NOT NULL,
    finalDate    DATE,
    user_id      INT(10) NOT NULL,
    PRIMARY KEY (project_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Task
(
    task_id     INT(10) NOT NULL AUTO_INCREMENT,
    title       VARCHAR(30) NOT NULL,
    description VARCHAR(255),
    project_id  INT(10) NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (project_id) REFERENCES Project (project_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Subtask
(
    subtask_id     INT(10) NOT NULL AUTO_INCREMENT,
    title          VARCHAR(30) NOT NULL,
    description    VARCHAR(255),
    estimated_time INT(10),
    final_time     INT(10),
    isDone       BIT(1)      NOT NULL DEFAULT b'0',
    task_id        INT(10) NOT NULL,
    PRIMARY KEY (subtask_id),
    FOREIGN KEY (task_id) REFERENCES Task (task_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE EmployeeSubtask
(
    employeesubtask_id INT(10) NOT NULL AUTO_INCREMENT,
    employee_id        INT(10) NOT NULL,
    subtask_id         INT(10) NOT NULL,
    PRIMARY KEY (employeesubtask_id),
    FOREIGN KEY (employee_id) REFERENCES Employee (employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (subtask_id) REFERENCES Subtask (subtask_id) ON DELETE CASCADE ON UPDATE CASCADE
);
