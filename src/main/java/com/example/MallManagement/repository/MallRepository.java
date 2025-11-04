package com.example.MallManagement.repository;
import com.example.MallManagement.model.Mall;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class MallRepository implements Repository<Mall> {

    private final List<Mall> malls = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    MallRepository(){
        Mall mall1 = new Mall(String.valueOf(idGenerator.getAndIncrement()), "MegaMall", "Berlin");
        Mall mall2 = new Mall(String.valueOf(idGenerator.getAndIncrement()), "CityMall", "Munich");
        malls.add(mall1);
        malls.add(mall2);
    }

    @Override
    public void save(Mall mall) {
        if (mall.getId() == null || mall.getId().isEmpty() || mall.getId().equals("0")) {
            mall.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(mall.getId());
        }
        malls.add(mall);
    }
    @Override
    public List<Mall> findAll() {
        return this.malls;
    }

    @Override
    public Mall findById(String id) {
        for (Mall m : malls)
            if (m.getId().equals(id))
                return m;
        return null;
    }

    @Override
    public void delete(String id) {
        malls.removeIf(m -> m.getId().equals(id));
    }
}
