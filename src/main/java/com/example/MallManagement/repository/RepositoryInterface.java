package com.example.MallManagement.repository;

import java.util.List;

public interface RepositoryInterface<T> {
    void save(T entity);
    List<T> findAll();
    T findById(String id);
    void delete(String id);
    void update(String id,  T updatedEntity);
}
