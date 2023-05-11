package nazzr.alphasolutionsexam.controller;

import jakarta.servlet.http.HttpSession;
import nazzr.alphasolutionsexam.model.User;
import nazzr.alphasolutionsexam.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    //----------------------------------------------------LOGIN-----------------------------------------------------\\
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        HttpSession session, Model model) {
        User user = loginService.getUser(email, password);
        if (user != null) {
            if (user.getPassword().equals(password))
                session.setAttribute("user", user);
            session.setMaxInactiveInterval(900);
            return "redirect:/dashboard";
        }
        model.addAttribute("wrongCredentials", true);
        return "login";
    }

    //--------------------------------------------------SIGN--UP----------------------------------------------------\\
    @GetMapping("/signup")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        loginService.createUser(user);
        return "redirect:/login";
    }

    //----------------------------------------------------LOGOUT----------------------------------------------------\\
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An error occurred: " + ex.getMessage());
        return "error";
    }
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404Error(ResponseStatusException ex, Model model) {
        model.addAttribute("errorMessage", "The page you requested could not be found." + ex.getMessage());
        return "error404";
    }

}
