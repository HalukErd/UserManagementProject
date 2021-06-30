package com.avansas.UserManagementProject.model.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@RequiredArgsConstructor

@Entity(name = "UserInformation")
@Table(
        name = "user_information",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_email",
                        columnNames = "email"
                )
        }
)
public class UserInformationEntity {

    @Id
    @SequenceGenerator(
            name = "user_information_sequence",
            sequenceName = "user_information_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_information_sequence"
    )
    private Long Id;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String birthDay;

    public UserInformationEntity(String name, String lastName, String email, String phoneNumber, String birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }
}