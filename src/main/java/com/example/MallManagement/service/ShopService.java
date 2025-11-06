package com.example.MallManagement.service;

import com.example.MallManagement.model.Shop;
import com.example.MallManagement.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopService extends com.example.MallManagement.service.Service<Shop> {

    public ShopService(ShopRepository shopRepo) {
        super(shopRepo);
    }

}
