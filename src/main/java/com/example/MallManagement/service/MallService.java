package com.example.MallManagement.service;

import com.example.MallManagement.model.Mall;
import com.example.MallManagement.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService {

    private final MallRepository mallRepository;

    @Autowired
    public MallService(MallRepository mallRepository) {
        this.mallRepository = mallRepository;
    }

    public List<Mall> findAll() {
        return mallRepository.findAll();
    }

    public Mall findById(Long id) {
        return mallRepository.findById(id).orElse(null);
    }

    public Mall save(Mall mall) {
        return mallRepository.save(mall);
    }

    public void delete(Long id) {
        mallRepository.deleteById(id);
    }

    public List<Mall> findFiltered(
            String searchTerm,
            String searchAttribute,
            String sortBy,
            String direction
    ) {
        if (searchTerm == null) searchTerm = "";
        if (searchAttribute == null) searchAttribute = "name";

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return mallRepository.searchByAttribute(searchTerm, searchAttribute, sort);
    }
}
