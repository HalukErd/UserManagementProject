package com.avansas.UserManagementProject.controller;

import com.avansas.UserManagementProject.controller.model.UserRequest;
import com.avansas.UserManagementProject.controller.model.UserResponse;
import com.avansas.UserManagementProject.mapper.MapperForUser;
import com.avansas.UserManagementProject.security.jwt.UsernamePasswordAuthenticationRequest;
import com.avansas.UserManagementProject.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.avansas.UserManagementProject.model.enums.UserPermission.USER_DELETE;

@Controller
@RequestMapping
public class TemplateController {

    UserService userService;
    MapperForUser mapperForUser;

    public TemplateController(UserService userService, MapperForUser mapperForUser) {
        this.userService = userService;
        this.mapperForUser = mapperForUser;
    }

    //    @GetMapping("login-view")
//    public String getLogin(Model model) {
////        model.addAttribute("login", new Login())
//        System.out.println("login controller invoked.");
//        return "login-view";
//    }

    @GetMapping("/login")
    public String addBookView(Model model) {
        model.addAttribute("request", new UsernamePasswordAuthenticationRequest());
        return "login-view";
    }

//    @PostMapping("/login")
//    public RedirectView addBook(@ModelAttribute("request") UsernamePasswordAuthenticationRequest request, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("/login", true);
//        System.out.println(String.format(("Username: %s, Password: %s"), request.getUsername(), request.getPassword()));
//
//        redirectAttributes.addFlashAttribute("request", request);
//        return redirectView;
//    }

    @GetMapping("signup")
    public String getSignUp(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "signup-view";
    }

    @PostMapping("signup")
    public RedirectView postSignUp(@ModelAttribute("userRequest") UserRequest userRequest, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/login", true);
        System.out.println(userRequest.toString());
        redirectAttributes.addFlashAttribute("savedUser", userRequest);
        redirectAttributes.addFlashAttribute("addUserSuccess", true);
        return redirectView;
    }

    @GetMapping("users")
    public String getUsers(Model model, HttpServletRequest request) {
        List<UserResponse> users = userService.getAllUsers().stream()
                .map(mapperForUser::convertToUserResponse)
                .collect(Collectors.toList());
        System.out.println(request.getHeader("Authorization"));

        model.addAttribute("users", users);
//        boolean hasDeleteAuth = userDetails.getAuthorities().stream().anyMatch(s -> s.getAuthority().equals(USER_DELETE.name()));
//        System.out.println(hasDeleteAuth);
        model.addAttribute("hasDeleteUpdateAuthority", true);
        return "users-view";
    }
}