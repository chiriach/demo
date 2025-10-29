package com.example.MallManagement.repository;
import com.example.MallManagement.model.Mall;
import java.util.*;

@org.springframework.stereotype.Repository
public class MallRepository implements Repository<Mall> {
    private final List<Mall> malls = new ArrayList<>();

    @Override
    public void save(Mall mall) {
        delete(mall.getId());
        malls.add(mall);
    }
    @Override
    public List<Mall> findAll() {
        return new ArrayList<>(malls);
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
