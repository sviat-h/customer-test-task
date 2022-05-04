package com.customer.service.impl;

import com.customer.exception.DataProcessingException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findActiveCustomers() {
        return customerRepository.findActiveCustomers();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Customer with id " + id + " not found"));
    }

    @Override
    public void removeById(Long id) {
        customerRepository.removeById(id);
    }
}
