package com.github.vishnukarthik.domain;

import com.github.vishnukarthik.dto.CustomerDto;
import lombok.Data;

@Data
public class Customer {
    private long id;
    private long phone;
    private String name;

    public Customer(long id, long phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public Customer(CustomerDto customerDto) {
        this.id = customerDto.getId();
        this.name = customerDto.getName();
        this.phone = customerDto.getPhone();
    }
}
