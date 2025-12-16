package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c " +
            "WHERE (:attribute = 'id' AND str(c.id) LIKE %:term%) " +
            "OR (:attribute = 'name' AND LOWER(c.name) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "OR (:attribute = 'currency' AND LOWER(c.currency) LIKE LOWER(CONCAT('%', :term, '%')))")
    List<Customer> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
