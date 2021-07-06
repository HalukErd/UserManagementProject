package com.avansas.UserManagementProject.controller.model;

import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserResponse {
    private Long id;

    private String username;

    private String password;

    private UserRole userRole;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String city;

    private String town;

    private String birthDay;


}