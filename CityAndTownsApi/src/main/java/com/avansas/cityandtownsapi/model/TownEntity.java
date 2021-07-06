package com.avansas.cityandtownsapi.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@RequiredArgsConstructor

@Table(name = "town")
@Entity(name = "Town")
public class TownEntity {

    @Id
    private Long id;

    @Column(
            name = "town_name",
            nullable = false
    )
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "city_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "city_town_fk"
            )
    )
    private CityEntity cityEntity;
}
