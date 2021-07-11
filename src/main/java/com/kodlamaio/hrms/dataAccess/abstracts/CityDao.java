package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityDao extends JpaRepository<City, Integer> {
    List<City> findFirst10ByNameContainingIgnoreCase(@Param("name") String name);

    List<City> getByStateId(int stateId);

    Optional<City> findById(int id);
}
