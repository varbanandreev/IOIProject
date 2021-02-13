package com.java.untitled.data.repository;

import com.java.untitled.data.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
