package com.rental.service;

import com.rental.model.Customer;

public interface RentalStatementService {
    String generateStatement(Customer customer);
}
