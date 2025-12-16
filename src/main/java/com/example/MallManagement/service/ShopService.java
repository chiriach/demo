package com.example.MallManagement.service;

import com.example.MallManagement.model.Shop;
import com.example.MallManagement.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.    util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepo;

    @Autowired
    public ShopService(ShopRepository shopRepo) {this.shopRepo = shopRepo;}

    public List<Shop> findAll() {return shopRepo.findAll();}

    public Shop findById(Long id) {return shopRepo.findById(id).orElse(null);}

    public List<Shop> findByFloorId(Long floorId) {return shopRepo.findByFloorId(floorId);}

    @Transactional
    public void save(Shop shop) {shopRepo.save(shop);}

    @Transactional
    public void delete(Long id) { shopRepo.deleteById(id); }

    public List<Shop> findFiltered(String searchTerm, String searchAttribute, String sortBy, String direction) {
        if (searchTerm == null) searchTerm = "";
        if (searchAttribute == null) searchAttribute = "name";

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return shopRepo.searchByAttribute(searchTerm, searchAttribute, sort);
    }
}