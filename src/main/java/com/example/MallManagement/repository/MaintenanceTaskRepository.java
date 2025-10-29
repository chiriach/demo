package com.example.MallManagement.repository;
import com.example.MallManagement.model.MaintenanceTask;
import java.util.*;

@org.springframework.stereotype.Repository
public class MaintenanceTaskRepository implements Repository<MaintenanceTask> {
    private final List<MaintenanceTask> maintenanceTasks = new ArrayList<>();

    @Override
    public void save(MaintenanceTask maintenanceTask) {
        delete(maintenanceTask.getId());
        maintenanceTasks.add(maintenanceTask);
    }
    @Override
    public List<MaintenanceTask> findAll() {
        return new ArrayList<>(maintenanceTasks);
    }

    @Override
    public MaintenanceTask findById(String id) {
        for (MaintenanceTask mt : maintenanceTasks)
            if (mt.getId().equals(id))
                return mt;
        return null;
    }

    @Override
    public void delete(String id) {
        maintenanceTasks.removeIf(ms -> ms.getId().equals(id));
    }
}
