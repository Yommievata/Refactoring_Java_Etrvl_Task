package com.rental.repository;

import com.rental.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
}
