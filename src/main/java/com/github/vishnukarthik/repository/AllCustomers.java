package com.github.vishnukarthik.repository;

import com.github.vishnukarthik.domain.Customer;
import com.github.vishnukarthik.dto.CustomerDto;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AllCustomers {

    private SessionFactory sessionFactory;

    @Autowired
    public AllCustomers(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Customer findByPhoneNo(long phoneNo) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(CustomerDto.class);
        criteria.add(Restrictions.eq("phone", phoneNo));
        CustomerDto customerDto = (CustomerDto) criteria.uniqueResult();
        return customerDto == null ? null : new Customer(customerDto);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Customer customer) {
        CustomerDto customerDto = new CustomerDto(customer);
        sessionFactory.getCurrentSession().save(customerDto);
    }
}
