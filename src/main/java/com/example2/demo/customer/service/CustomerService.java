package com.example2.demo.customer.service;

import com.example2.demo.customer.repository.CustomerEntity;
import com.example2.demo.customer.repository.CustomerRepository;
import com.example2.demo.customer.rest.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomer(Integer id) {

        Optional<CustomerEntity> optionalWithCustomer = customerRepository.findById(id);
        if (optionalWithCustomer.isPresent()) {
            CustomerEntity customerEntity = optionalWithCustomer.get();
            Customer customer = new Customer();
            customer.setName(customerEntity.getName());
            customer.setPrenume(customerEntity.getPrenume());
            customer.setAge(customerEntity.getAge());
            return customer;
        }
        return null;
    }

    public List<Customer> getCustomerList() {
        List<CustomerEntity> all = (List<CustomerEntity>) customerRepository.findAll();
        List<Customer> response = new ArrayList<>();

        for (CustomerEntity customerEntity : all) {
            Customer customer = new Customer();
            customer.setName(customerEntity.getName());
            customer.setPrenume(customerEntity.getPrenume());
            customer.setAge(customerEntity.getAge());
            response.add(customer);
        }
        return response;
    }

    public void addCustomer(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(customer.getName());
        entity.setAge(customer.getAge());
        entity.setPrenume(customer.getPrenume());

        customerRepository.save(entity);
    }

    public void modifyCustomer(Integer id, Customer customer) {
        Optional<CustomerEntity> optionalWithCustomer = customerRepository.findById(id);
        if (optionalWithCustomer.isPresent()) {
            CustomerEntity customerEntity = optionalWithCustomer.get();

            customerEntity.setName(customer.getName());
            customerEntity.setPrenume(customer.getPrenume());
            customerEntity.setAge(customer.getAge());
            customerRepository.save(customerEntity);
        }
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public void deleteList() {
        customerRepository.deleteAll();
    }

}
