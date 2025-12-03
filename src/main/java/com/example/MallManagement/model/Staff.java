package com.example.MallManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "staff_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name ist erforderlich")
    private String name;

    @Min(value = 0, message = "Gehalt muss positiv sein")
    private int salary;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<StaffAssignment> assignments = new ArrayList<>();

    public Staff() {}

    public Staff(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public List<StaffAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<StaffAssignment> assignments) { this.assignments = assignments; }
}