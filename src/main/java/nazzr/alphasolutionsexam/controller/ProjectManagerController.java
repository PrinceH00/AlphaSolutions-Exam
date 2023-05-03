package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.service.LoginService;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectManagerController {

    private final LoginService loginService;

    public ProjectManagerController(LoginService loginService) {
        this.loginService = loginService;
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }



}
