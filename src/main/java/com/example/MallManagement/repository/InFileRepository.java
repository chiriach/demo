package com.example.MallManagement.repository;

import com.example.MallManagement.model.Identifiable;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class InFileRepository<E extends Identifiable> implements RepositoryInterface<E> {

    private final String filePath;
    private final ObjectMapper mapper;
    private final Class<E> clazz;
    protected final List<E> entities;
    protected final AtomicLong idGenerator = new AtomicLong(1);

    public InFileRepository(String filePath, Class<E> clazz) {
        this.filePath = filePath;
        this.clazz = clazz;
        this.mapper = new ObjectMapper();
        this.entities = loadFromFile();
    }

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
        saveToFile();
        entities.add(entity);
    }

    @Override
    public List<E> findAll() {
        return entities;
    }

    @Override
    public E findById(String id) {
        return entities.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        entities.removeIf(e -> e.getId().equals(id));
        saveToFile();
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
        saveToFile();
    }

    private List<E> loadFromFile() {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            // Read JSON array into List<E>
            return mapper.readValue(file,
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    private void saveToFile(){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), entities);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save devices to file");
        }
    }
}
