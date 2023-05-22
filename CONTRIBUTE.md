## Contribute
This file will help you get started and up to date, so you can start working as quickly as possible.  

### How to set up project
To set up the project correctly follow this simple step to step guide :)

###
#### Step 1 - Installation of programs

1.   Install the newest version of Java.
2.   Install IntelliJ.
3.   Install MySQL Workbench.
4.   Install Git.

###
#### Step 2 - Set-up database
1.   Get the SQL scripts from the sql folder in /src/main/resources/sql 
2.   Run the scripts in your MySQL Workbench.

###
#### Step 3 - Connect to REPO and GitHub projects
1.   Make sure you have been added to GitHub projects and the Repository as a contributor by another team member.
2.   Clone the project in IntelliJ.
3.   Create a file **applications.properties** in recourses folder **IMPORTANT** that the file is not added to GitHub.
4.   The Application.properties template will be listed under here:

```
url = jdbc:mysql://localhost:3306/projectmanager
username = <Username>
password = <Password>

ProjectManager.repository.impl = ProjectManager_DB
server.error.whitelabel.enabled = false
```
This template can be pasted in to **application.properties** the tags **Username** and **Password** should be changed to match your Database.  

###
#### Step 4 - Test program
1.    Run the application with your **application.properties** to make sure everything checks out.
2.    Lastly check for any errors is occurring. If this is the case see if you missed any steps or ask a college.

###
#### YOU SHOULD NOW BE UP-TO-DATE WELCOME TO THE TEAM AND **GOOD LUCK!**

