package com.example.MallManagement.service;

import java.util.List;

public interface ServiceInterface<T> {
     void add(T t);
     List<T> findAll();
     T findById(String id);
     void delete(String id);
     void update(String id, T t);
}
