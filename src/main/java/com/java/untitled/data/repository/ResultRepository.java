package com.java.untitled.data.repository;

import com.java.untitled.data.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query("SELECT r FROM Result r INNER JOIN Country c ON r.country.id = c.id WHERE c.name = :name")
    List<Result> findAllByCountryName(@Param("name") String name);
}
