package com.customer.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
