package com.customer.service;

import com.customer.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> findActiveCustomers();

    Customer findById(Long id);

    void removeById(Long id);
}
