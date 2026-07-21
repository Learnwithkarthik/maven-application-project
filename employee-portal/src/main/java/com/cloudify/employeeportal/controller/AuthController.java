package com.cloudify.employeeportal.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.cloudify.employeeportal.model.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private static final String DEMO_USERNAME = "admin";
    private static final String DEMO_PASSWORD = "admin123";

    @GetMapping({"/", "/login"})
    public String loginPage(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") != null) {
            return "redirect:/dashboard";
        }

        if (!model.containsAttribute("loginRequest")) {
            model.addAttribute("loginRequest", new LoginRequest());
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("loginRequest") LoginRequest loginRequest,
            BindingResult bindingResult,
            HttpSession session,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        if (DEMO_USERNAME.equals(loginRequest.getUsername())
                && DEMO_PASSWORD.equals(loginRequest.getPassword())) {
            session.setAttribute("loggedInUser", loginRequest.getUsername());
            return "redirect:/dashboard";
        }

        model.addAttribute("loginError", "Invalid username or password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
