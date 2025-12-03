package com.example.MallManagement.service;

import com.example.MallManagement.model.Mall;
import com.example.MallManagement.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MallService {

    private final MallRepository mallRepo;

    @Autowired
    public MallService(MallRepository mallRepo) {this.mallRepo = mallRepo;}

    public List<Mall> findAll() {return mallRepo.findAll();}

    public Mall findById(Long id) {return mallRepo.findById(id).orElse(null);}

    @Transactional
    public void save(Mall mall) {mallRepo.save(mall);}

    @Transactional
    public void delete(Long id) {mallRepo.deleteById(id);}
}