package com.rental.repository;

import com.rental.model.Customer;

public interface CustomerRepository {
    /**
     * Saves a customer.
     * If the customer has no ID, a new one is assigned.
     *
     * @param customer the customer to save
     * @return the saved customer with an assigned ID if necessary
     */
    Customer save(Customer customer);
}
