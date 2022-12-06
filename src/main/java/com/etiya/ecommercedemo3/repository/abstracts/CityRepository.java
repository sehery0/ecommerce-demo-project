package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
    boolean existsById(int id);
}
