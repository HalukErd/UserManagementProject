package com.avansas.UserManagementProject.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class UserInformation {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Size(min = 10, max = 11)
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String birthDay;
}