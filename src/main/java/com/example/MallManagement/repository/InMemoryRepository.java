package com.example.MallManagement.repository;

import com.example.MallManagement.model.Identifiable;
import com.example.MallManagement.model.Mall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T extends Identifiable> implements RepositoryInterface<T>{

    protected final List<T> entities = new ArrayList<>();
    protected final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(T entity) {
        entities.add(entity);
    }

    @Override
    public List<T> findAll() {
        return this.entities;
    }

    @Override
    public T findById(String id) {
        for (T t : entities)
            if (t.getId().equals(id))
                return t;
        return null;
    }

    @Override
    public void delete(String id) {
        entities.removeIf(e -> e.getId().equals(id));
    }
}
