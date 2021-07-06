package com.avansas.UserManagementProject.model.entity;

import com.avansas.UserManagementProject.model.enums.UserRole;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "ApplicationUserEntity")
@Table(
        name = "users",
        indexes = {
                @Index(name = "usernameindex", columnList = "username", unique = true)
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_username",
                        columnNames = "username"
                )
        }
)
public class UserEntity {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;


    private String username;

    private String password;

    private UserRole userRole;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_information",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_information_id_fk"
            )
    )
    private UserInformationEntity userInformationEntity;

    public UserEntity(String username, String password, UserRole userRole, UserInformationEntity userInformationEntity) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userInformationEntity = userInformationEntity;
    }
}