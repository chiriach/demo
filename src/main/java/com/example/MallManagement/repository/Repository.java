package com.example.MallManagement.repository;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    List<T> findAll();
    T findById(String id);
    void delete(String id);
}
