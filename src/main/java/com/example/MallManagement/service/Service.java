package com.example.MallManagement.service;

import com.example.MallManagement.model.Identifiable;
import com.example.MallManagement.repository.InMemoryRepository;

import java.util.*;

public class Service<E extends Identifiable> implements ServiceInterface<E> {

    protected final InMemoryRepository<E> repository;

    public Service(InMemoryRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public void add(E entity) {
        repository.save(entity);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void update(String id, E updateEntity) {
        repository.update(id, updateEntity);
    }
}

