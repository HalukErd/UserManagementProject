package com.avansas.cityandtownsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(
        name = "city",
        indexes = @Index(columnList = "city_name")
)
@Entity(name = "City")
public class CityEntity { // edit here (index name)

    @Id
    private Long id;

    @Column(
            name = "city_name",
            nullable = false
    )
    private String name;

    @OneToMany(
            mappedBy = "cityEntity",
            fetch = FetchType.LAZY
    )
    private List<TownEntity> towns = new ArrayList<>();
}