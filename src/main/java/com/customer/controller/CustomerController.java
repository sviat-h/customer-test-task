package com.customer.controller;

import com.customer.model.Customer;
import com.customer.model.dto.request.CustomerRequestDto;
import com.customer.model.dto.request.CustomerUpdateRequestDto;
import com.customer.model.dto.response.CustomerResponseDto;
import com.customer.service.CustomerService;
import com.customer.service.mapper.CustomerMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.mapToModel(customerRequestDto);
        Customer savedCustomer = customerService.save(customer);
        return customerMapper.mapToDto(savedCustomer);
    }

    @GetMapping
    public List<CustomerResponseDto> getAll() {
        return customerService.findActiveCustomers().stream()
                .map(customerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return customerMapper.mapToDto(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@PathVariable Long id,
                                      @RequestBody CustomerUpdateRequestDto customerRequestDto) {
        Customer customerFromDb = customerService.findById(id);
        customerFromDb.setPhone(customerRequestDto.getPhone());
        customerFromDb.setFullName(customerRequestDto.getFullName());
        return customerMapper.mapToDto(customerService.save(customerFromDb));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.removeById(id);
    }
}
