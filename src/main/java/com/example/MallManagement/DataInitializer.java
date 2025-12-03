package com.example.MallManagement;

import com.example.MallManagement.model.*;
import com.example.MallManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private MallRepository mallRepository;
    @Autowired private FloorRepository floorRepository;
    @Autowired private ShopRepository shopRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private PurchaseRepository purchaseRepository;
    @Autowired private MaintenanceStaffRepository maintenanceStaffRepository;
    @Autowired private SecurityStaffRepository securityStaffRepository;
    @Autowired private ElectricalAssetRepository electricalAssetRepository;
    @Autowired private MaintenanceTaskRepository maintenanceTaskRepository;
    @Autowired private StaffAssignmentRepository staffAssignmentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (mallRepository.count() > 0) {
            return;
        }

        // 1. Malls
        List<Mall> malls = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            malls.add(mallRepository.save(new Mall("Mall " + i, "City " + i)));
        }

        // 2. Floors
        List<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Mall mall = malls.get((i - 1) % malls.size());
            floors.add(floorRepository.save(new Floor(i, mall)));
        }

        // 3. Shops
        List<Shop> shops = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Floor floor = floors.get((i - 1) % floors.size());
            shops.add(shopRepository.save(new Shop("Shop " + i, "Owner " + i, 50.0 + (i * 10), (i % 5) + 1, floor)));
        }

        // 4. Customers (Fixed: Model expects Currency, not Email)
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            customers.add(customerRepository.save(new Customer("Customer " + i, "USD")));
        }

        // 5. Maintenance Staff (Fixed: Enum Case)
        List<MaintenanceStaff> mStaffs = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            MaintenanceStaff.Type type = (i % 2 == 0) ? MaintenanceStaff.Type.Electrical : MaintenanceStaff.Type.Cleaning;
            mStaffs.add(maintenanceStaffRepository.save(new MaintenanceStaff("M-Staff " + i, type, 3000 + (i * 100))));
        }

        // 6. Security Staff
        List<SecurityStaff> sStaffs = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            sStaffs.add(securityStaffRepository.save(new SecurityStaff("S-Staff " + i, "Badge-" + (100 + i), 2500 + (i * 100))));
        }

        // 7. Electrical Assets (Fixed: Enum Case)
        for (int i = 1; i <= 10; i++) {
            Floor floor = floors.get((i - 1) % floors.size());
            ElectricalAsset.Type type = (i % 2 == 0) ? ElectricalAsset.Type.Light : ElectricalAsset.Type.Lift;
            ElectricalAsset.Status status = (i % 3 == 0) ? ElectricalAsset.Status.Down : ElectricalAsset.Status.Working;
            electricalAssetRepository.save(new ElectricalAsset(type, status, floor));
        }

        // 8. Purchases
        for (int i = 1; i <= 10; i++) {
            Customer customer = customers.get((i - 1) % customers.size());
            Shop shop = shops.get((i - 1) % shops.size());
            purchaseRepository.save(new Purchase(100.0 + (i * 20), customer, shop));
        }

        // 9. Staff Assignments
        for (int i = 1; i <= 10; i++) {
            Floor floor = floors.get((i - 1) % floors.size());
            SecurityStaff staff = sStaffs.get((i - 1) % sStaffs.size());
            StaffAssignment.Shift shift = (i % 2 == 0) ? StaffAssignment.Shift.Morning : StaffAssignment.Shift.Evening;
            staffAssignmentRepository.save(new StaffAssignment(shift, floor, staff));
        }

        // 10. Maintenance Tasks (Now works perfectly with your Model)
        for (int i = 1; i <= 10; i++) {
            Floor floor = floors.get((i - 1) % floors.size());
            MaintenanceStaff staff = mStaffs.get((i - 1) % mStaffs.size());

            // Using .values() to pick valid status safely
            MaintenanceTask.Status status = MaintenanceTask.Status.values()[i % MaintenanceTask.Status.values().length];

            maintenanceTaskRepository.save(new MaintenanceTask("Task " + i, status, staff, floor));
        }
    }
}