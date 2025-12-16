package com.example.MallManagement.repository;

import com.example.MallManagement.model.Mall;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallRepository extends JpaRepository<Mall, Long> {

    @Query("SELECT m FROM Mall m " +
            "WHERE (:attribute = 'id' AND str(m.id) LIKE %:term%) " +
            "OR (:attribute = 'name' AND LOWER(m.name) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "OR (:attribute = 'city' AND LOWER(m.city) LIKE LOWER(CONCAT('%', :term, '%')))")
    List<Mall> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
