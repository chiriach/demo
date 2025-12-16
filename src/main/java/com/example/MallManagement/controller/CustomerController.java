package com.example.MallManagement.controller;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String listCustomers(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "name") String searchAttribute,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute("customers", customerService.findFiltered(searchTerm, searchAttribute, sortBy, direction));
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchAttribute", searchAttribute);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);
        return "customer/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) return "customer/form";
        customerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) return "redirect:/customers";
        model.addAttribute("customer", customer);
        return "customer/form";
    }

    @PostMapping("/{id}/update")
    public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute Customer updatedCustomer, BindingResult result) {
        if (result.hasErrors()) {
            updatedCustomer.setId(id);
            return "customer/form";
        }
        updatedCustomer.setId(id);
        customerService.save(updatedCustomer);
        return "redirect:/customers";
    }
}
