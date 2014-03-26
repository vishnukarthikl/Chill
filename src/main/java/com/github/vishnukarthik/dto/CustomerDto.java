package com.github.vishnukarthik.dto;

import com.github.vishnukarthik.domain.Customer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "phone_no")
    private long phone;

    public CustomerDto(Customer customer) {
        this.phone = customer.getPhone();
        this.name = customer.getName();
    }
}
