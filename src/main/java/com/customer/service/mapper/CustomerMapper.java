package com.customer.service.mapper;

import com.customer.model.Customer;
import com.customer.model.dto.request.CustomerRequestDto;
import com.customer.model.dto.response.CustomerResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements RequestDtoMapper<CustomerRequestDto, Customer>,
        ResponseDtoMapper<CustomerResponseDto, Customer> {
    @Override
    public Customer mapToModel(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        return customer;
    }

    @Override
    public CustomerResponseDto mapToDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setId(customer.getId());
        dto.setFullName(customer.getFullName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        return dto;
    }
}
