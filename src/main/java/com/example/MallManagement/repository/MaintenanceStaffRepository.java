package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceStaff;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceStaffRepository extends InFileRepository<MaintenanceStaff> implements RepositoryInterface<MaintenanceStaff>{

    public MaintenanceStaffRepository() {
        // Sample staff
//        super.save(new MaintenanceStaff(null, "John Doe", MaintenanceStaff.Type.Electrical, 3000));
//        super.save(new MaintenanceStaff(null, "Jane Smith", MaintenanceStaff.Type.Cleaning, 2500));
        super("src/main/resources/data/maintenance_staff.json", MaintenanceStaff.class);

    }
}
