package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {

    List<Floor> findByMallId(Long mallId);

    @Query("SELECT f FROM Floor f " +
            "WHERE (:attribute = 'id' AND str(f.id) LIKE %:term%) " +
            "OR (:attribute = 'number' AND str(f.number) LIKE %:term%) " +
            "OR (:attribute = 'mall' AND LOWER(f.mall.name) LIKE LOWER(CONCAT('%', :term, '%')))")
    List<Floor> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
