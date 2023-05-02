package nazzr.alphasolutionsexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        HttpSession session, Model model)
    {

        User user = loginService.getUser(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(900);
            return "redirect:/dashboard";
        }
        // wrong credentials
        model.addAttribute("wrongCredentials", true);
        return "redirect:/login";
    }

}
