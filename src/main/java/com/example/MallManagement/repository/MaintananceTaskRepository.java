package com.example.MallManagement.repository;
import com.example.MallManagement.model.MaintananceTask;
import java.util.*;

public class MaintananceTaskRepository implements Repository<MaintananceTask> {
    private final List<MaintananceTask> maintananceTasks = new ArrayList<>();

    @Override
    public void save(MaintananceTask maintananceTask) {
        delete(maintananceTask.getId());
        maintananceTasks.add(maintananceTask);
    }
    @Override
    public List<MaintananceTask> findAll() {
        return new ArrayList<>(maintananceTasks);
    }

    @Override
    public MaintananceTask findById(String id) {
        for (MaintananceTask mt : maintananceTasks)
            if (mt.getId().equals(id))
                return mt;
        return null;
    }

    @Override
    public void delete(String id) {
        maintananceTasks.removeIf(ms -> ms.getId().equals(id));
    }
}
