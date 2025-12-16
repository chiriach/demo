package com.example.MallManagement.repository;

import com.example.MallManagement.model.Shop;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByFloorId(Long floorId);

    @Query("SELECT s FROM Shop s " +
            "WHERE (:attribute = 'id' AND str(s.id) LIKE %:term%) " +
            "OR (:attribute = 'name' AND LOWER(s.name) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "OR (:attribute = 'ownerName' AND LOWER(s.ownerName) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "OR (:attribute = 'floor' AND str(s.floor.number) LIKE %:term%)")
    List<Shop> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
