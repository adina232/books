package com.example2.demo.customer.rest;

import com.example2.demo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerWithPathVariable(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/customer")
    public Customer getCustomerWithRequestParam(@RequestParam(name = "customer-id") Integer id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomer() {
        return customerService.getCustomerList();
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/customer/modify/{id}")
    public void modifyCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.modifyCustomer(id, customer);
    }

    @DeleteMapping("/customer/delete")
    public void deleteCustomer(@RequestParam (value = "id") Integer id) {
        customerService.deleteCustomer(id);
    }

    @DeleteMapping("/customer/delete-all")
    public void deleteList() {
        customerService.deleteList();
    }

}
