package com.avansas.UserManagementProject.controller.model;

import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private UserRole userRole;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Size(min = 10, max = 11)
    private String phoneNumber;

    @NotBlank
    private String city;

    @NotBlank
    private String town;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String birthDay;
}