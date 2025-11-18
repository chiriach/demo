package com.example.MallManagement.repository;

import com.example.MallManagement.model.SecurityStaff;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityStaffRepository extends InMemoryRepository<SecurityStaff> {

    public SecurityStaffRepository() {
        // Sample security staff
        save(new SecurityStaff(null, "Alice Johnson", "B1234", 3200));
        save(new SecurityStaff(null, "Bob Lee", "B5678", 3000));
    }
}
