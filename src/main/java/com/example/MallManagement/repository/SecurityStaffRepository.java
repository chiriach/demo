package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.model.SecurityStaff;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityStaffRepository extends InFileRepository<SecurityStaff> implements RepositoryInterface<SecurityStaff>{

    public SecurityStaffRepository() {
//        save(new SecurityStaff(null, "Alice Johnson", "B1234", 3200));
//        save(new SecurityStaff(null, "Bob Lee", "B5678", 3000));
        super("src/main/resources/data/security_staff.json", SecurityStaff.class);
    }
}
