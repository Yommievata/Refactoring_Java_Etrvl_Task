package com.rental.repository;

import com.rental.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Long nextId = 1L;

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            return new Customer(nextId++, customer.getName());
        }
        return customer;
    }
}
