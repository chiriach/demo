package com.example.MallManagement.repository;

import com.example.MallManagement.model.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<E extends Identifiable> implements RepositoryInterface<E> {

    protected final List<E> data = new ArrayList<>();
    protected final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(E entity) {

        // Assign new ID if missing, empty or equals "0"
        if (entity.getId() == null ||
                entity.getId().trim().isEmpty() ||
                entity.getId().equals("0")) {

            entity.setId(String.valueOf(idGenerator.getAndIncrement()));
        }
        else {
            // Update existing → remove old version
            delete(entity.getId());
        }

        data.add(entity);
    }

    @Override
    public List<E> findAll() {
        return data;
    }

    @Override
    public E findById(String id) {
        return data.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        data.removeIf(e -> e.getId().equals(id));
    }
}
