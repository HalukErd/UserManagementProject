package com.avansas.UserManagementProject.controller.model;

import com.avansas.UserManagementProject.model.UserInformation;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

    @Valid
    private UserInformation userInformation;
}