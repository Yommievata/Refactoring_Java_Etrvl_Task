package com.rental.service;

import com.rental.model.MovieRental;

public interface RentalPriceService {
    /**
     * Calculates the rental price for a given movie rental.
     * The price is determined by the movie category and the number of days rented.
     *
     * @param movieRental the rental details
     * @return the calculated rental price
     */
    double calculateRentalPrice(MovieRental movieRental);

    /**
     * Calculates the loyalty points for a given movie rental.
     * Loyalty points depend on the movie category and the number of days rented.
     *
     * @param movieRental the rental details
     * @return the calculated loyalty points
     */
    int calculateLoyaltyPoints(MovieRental movieRental);
}
