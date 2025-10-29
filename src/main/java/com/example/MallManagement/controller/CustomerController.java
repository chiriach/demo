package com.example.MallManagement.controller;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers"; // → customers.html
    }

    @PostMapping("/add")
    @ResponseBody
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "Kunde hinzugefügt!";
    }
}
