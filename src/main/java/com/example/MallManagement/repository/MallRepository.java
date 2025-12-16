package com.example.MallManagement.repository;

import com.example.MallManagement.model.Mall;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallRepository extends JpaRepository<Mall, Long> {

    List<Mall> findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(
            String name,
            String city,
            Sort sort
    );
}
