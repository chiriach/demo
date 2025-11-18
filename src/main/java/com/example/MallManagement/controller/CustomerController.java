package com.example.MallManagement.controller;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.add(customer);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable String id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) return "redirect:/customers";

        model.addAttribute("customer", customer);
        return "customer/form";
    }

    @PostMapping("/{id}/update")
    public String updateCustomer(@PathVariable String id,
                                 @ModelAttribute Customer updatedCustomer) {

        customerService.update(id, updatedCustomer);
        return "redirect:/customers";
    }

}
