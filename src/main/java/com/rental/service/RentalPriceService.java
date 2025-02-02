package com.rental.service;

import com.rental.model.MovieRental;

public interface RentalPriceService {
    double calculateRentalPrice(MovieRental movieRental);
    int calculateLoyaltyPoints(MovieRental movieRental);
}
