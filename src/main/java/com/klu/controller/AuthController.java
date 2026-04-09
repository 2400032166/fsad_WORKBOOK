package com.klu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.klu.service.UserService;
@RestController
@RequestMapping("/")   // base path (optional)
public class AuthController {
    @Autowired
    private UserService service;
    @GetMapping("/")
    public String home() {
        return "Welcome to Skill-15 Application 🚀";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        return service.login(username, password);
    }
    @GetMapping("/admin/add")
    public String adminAccess() {
        return "Admin can add employee";
    }
    @GetMapping("/employee/profile")
    public String employeeAccess() {
        return "Employee profile data";
    }
}