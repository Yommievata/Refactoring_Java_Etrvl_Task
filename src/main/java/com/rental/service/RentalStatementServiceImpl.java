package com.rental.service;

import com.rental.model.Customer;
import com.rental.model.MovieRental;

import java.util.Locale;

public class RentalStatementServiceImpl implements RentalStatementService {
    private final RentalPriceService priceService;

    public RentalStatementServiceImpl(RentalPriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public String generateStatement(Customer customer) {
        StringBuilder result = new StringBuilder()
                .append("Rental Record for ")
                .append(customer.getName())
                .append("\n");

        double totalAmount = 0;
        int loyaltyPoints = 0;

        for (MovieRental rental : customer.getMovieRental()) {
            double rentalAmount = priceService.calculateRentalPrice(rental);
            loyaltyPoints += priceService.calculateLoyaltyPoints(rental);

            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(String.format(Locale.US, "%.1f", rentalAmount))
                    .append("\n");

            totalAmount += rentalAmount;
        }

        result.append("Amount owed is ")
                .append(String.format(Locale.US, "%.1f", totalAmount))
                .append("\n");
        result.append("You earned ")
                .append(loyaltyPoints)
                .append(" loyalty points\n");

        return result.toString();
    }
}
