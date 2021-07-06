package com.avansas.UserManagementProject.model;

import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    private Long id;

    private String username;

    private String password;

    private UserRole userRole;

    private UserInformation userInformation;

    public User(String username, String password, UserRole userRole, UserInformation userInformation) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userInformation = userInformation;
    }
}