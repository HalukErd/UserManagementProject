package com.avansas.cityandtownsapi.repository;

import com.avansas.cityandtownsapi.model.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TownRepository extends JpaRepository<TownEntity, Long> {
    @Query("SELECT t.name FROM Town t WHERE t.cityEntity.id = ?1")
    Optional<List<String>> findTownsByCityId(Long cityId);
}