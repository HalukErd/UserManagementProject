package com.avansas.UserManagementProject.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class UserInformation {
    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String birthDay;

    private Address address;

}