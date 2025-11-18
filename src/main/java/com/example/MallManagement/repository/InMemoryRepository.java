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

    @Override
    public void update(String id, E updatedEntity) {
        E existing = findById(id);
        if (existing == null) {
            throw new RuntimeException("Entity with ID " + id + " not found.");
        }

        // Copy all fields from updatedEntity to existing, excluding 'id' and final fields
        try {
            Class<?> clazz = existing.getClass();
            while (clazz != null) { // include superclass fields
                var fields = clazz.getDeclaredFields();
                for (var field : fields) {
                    field.setAccessible(true);
                    if (!java.lang.reflect.Modifier.isFinal(field.getModifiers()) &&
                            !field.getName().equals("id")) { // don't overwrite ID
                        Object newValue = field.get(updatedEntity);
                        field.set(existing, newValue);
                    }
                }
                clazz = clazz.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to update entity", e);
        }
    }
}
