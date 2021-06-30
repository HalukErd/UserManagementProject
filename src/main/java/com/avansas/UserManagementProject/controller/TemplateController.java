package com.avansas.UserManagementProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("users")
    public String getUsers() {
        return "users";
    }

    @GetMapping("signup")
    public String getSignUp() {
        return "signup";
    }
}