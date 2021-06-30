package com.avansas.UserManagementProject.controller.model;

import com.avansas.UserManagementProject.model.UserInformation;
import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class UserResponse {
    private Long id;

    private String username;

    private UserRole userRole;

    private UserInformation userInformation;
}