package com.github.vishnukarthik.service;

import com.github.vishnukarthik.domain.Customer;
import com.github.vishnukarthik.repository.AllCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private AllCustomers allCustomers;

    public CustomerService() {
    }

    @Autowired
    public CustomerService(AllCustomers allCustomers) {
        this.allCustomers = allCustomers;
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(long phoneNo) {
        return allCustomers.findByPhoneNo(phoneNo);
    }
}
