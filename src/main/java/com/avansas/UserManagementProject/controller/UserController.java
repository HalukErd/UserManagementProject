package com.avansas.UserManagementProject.controller;

import com.avansas.UserManagementProject.controller.model.UserRequest;
import com.avansas.UserManagementProject.controller.model.UserResponse;
import com.avansas.UserManagementProject.mapper.MapperForUser;
import com.avansas.UserManagementProject.model.User;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import com.avansas.UserManagementProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    private final MapperForUser mapperForUser;

    @Autowired
    public UserController(UserService userService, MapperForUser mapperForUser) {
        this.userService = userService;
        this.mapperForUser = mapperForUser;
    }

//    @PostMapping("/signup")
//    public UserResponse save(@RequestBody @Valid UserRequest userRequest) {
//        User user = mapperForUser.convertToUser(userRequest);
//        return mapperForUser.convertToUserResponse(userService.saveUser(user));
//    }

//    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('user:read')")
//    public UserResponse get(@PathVariable("id") Long id) {
//        return mapperForUser.convertToUserResponse(userService.getUserById(id));
//    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('user:read')")
    public List<UserResponse> getAll() {
        return userService.getAllUsers().stream()
                .map(mapperForUser::convertToUserResponse)
                .collect(Collectors.toList());
    }

//    @PutMapping
//    @PreAuthorize("hasAuthority('user:write')")
//    public UserResponse put(@RequestBody @Valid UserRequest userRequest) {
//        UserEntity userEntity = mapperForUser.convertToUserEntity(userRequest);
//        return mapperForUser.convertToUserResponse(userService.updateUser(userEntity));
//    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public boolean delete(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }

    @GetMapping(value = "/check")
    public Collection<? extends GrantedAuthority> getCheck(@AuthenticationPrincipal UserDetails user) {
        return user.getAuthorities();
    }
}