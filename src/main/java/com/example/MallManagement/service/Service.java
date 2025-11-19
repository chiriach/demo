package com.example.MallManagement.service;

import com.example.MallManagement.model.Identifiable;
import com.example.MallManagement.repository.InFileRepository;
import com.example.MallManagement.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Service<E extends Identifiable> implements ServiceInterface<E> {

    // TODO uncomment this line, if you want to use in file storage!
    private final InFileRepository<E> repository;

    // TODO uncomment this constructor, if you want to use in file storage! + comment out the other constructor
    @Autowired
    public Service(InFileRepository<E> repository) {
        this.repository = repository;
    }



//    protected final InMemoryRepository<E> repository;
//
//    public Service(InMemoryRepository<E> repository) {
//        this.repository = repository;
//    }

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

