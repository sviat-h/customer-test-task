package com.customer.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
}
