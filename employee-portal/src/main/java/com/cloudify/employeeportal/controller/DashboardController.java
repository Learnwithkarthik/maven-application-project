package com.cloudify.employeeportal.controller;

import jakarta.servlet.http.HttpSession;
import com.cloudify.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployeeService employeeService;

    @Value("${app.version}")
    private String applicationVersion;

    public DashboardController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        model.addAttribute("username", session.getAttribute("loggedInUser"));
        model.addAttribute("totalEmployees", employeeService.findAll().size());
        model.addAttribute("activeEmployees", employeeService.countActiveEmployees());
        model.addAttribute("projects", 6);
        model.addAttribute("openTickets", 8);
        model.addAttribute("applicationVersion", applicationVersion);
        model.addAttribute("environment", "Development");

        return "dashboard";
    }

    @GetMapping("/employees")
    public String employees(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("applicationVersion", applicationVersion);
        return "employees";
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }
}
