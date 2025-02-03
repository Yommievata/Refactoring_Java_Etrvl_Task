package com.rental.service;

import com.rental.model.Customer;

public interface RentalStatementService {
    /**
     * Generates a rental statement for a given customer.
     * The statement includes the details of each rental and the total amount owed.
     *
     * @param customer the customer for whom the rental statement is generated
     * @return the generated rental statement as a string
     */
    String generateStatement(Customer customer);
}
