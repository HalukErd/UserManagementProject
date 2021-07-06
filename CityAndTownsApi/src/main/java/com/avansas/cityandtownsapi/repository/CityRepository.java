package com.avansas.cityandtownsapi.repository;

import com.avansas.cityandtownsapi.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    @Query("SELECT s.id FROM City s WHERE s.name = ?1")
    Optional<Long> findCityByName(String name);

}
