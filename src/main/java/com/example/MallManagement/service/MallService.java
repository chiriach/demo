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
            Long id,
            String name,
            String city,
            String sortBy,
            String direction
    ) {
        if (name == null) name = "";
        if (city == null) city = "";

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        List<Mall> malls =
                mallRepository.findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(
                        name, city, sort
                );

        if (id != null) {
            malls = malls.stream()
                    .filter(m -> m.getId().equals(id))
                    .toList();
        }

        return malls;
    }
}
