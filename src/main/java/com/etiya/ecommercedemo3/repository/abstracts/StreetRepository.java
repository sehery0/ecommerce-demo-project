package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Integer> {
}
