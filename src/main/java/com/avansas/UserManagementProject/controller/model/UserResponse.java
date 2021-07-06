package com.avansas.UserManagementProject.controller.model;

import com.avansas.UserManagementProject.model.UserInformation;
import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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