package com.avansas.UserManagementProject.model.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity(name = "Address")
@Table(name = "address")
public class AddressEntity {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;

    private String city;

    private String town;

    public AddressEntity(String city, String town) {
        this.city = city;
        this.town = town;
    }
}