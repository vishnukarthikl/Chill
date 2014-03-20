package com.github.vishnukarthik.domain;

import com.github.vishnukarthik.dto.CustomerDto;
import lombok.Data;

@Data
public class Customer {
    private long id;
    private long phoneNo;
    private String name;

    public Customer(long id, long phoneNo, String name) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.name = name;
    }

    public Customer(CustomerDto customerDto) {
        this.id = customerDto.getId();
        this.name = customerDto.getName();
        this.phoneNo = customerDto.getPhone();
    }
}
