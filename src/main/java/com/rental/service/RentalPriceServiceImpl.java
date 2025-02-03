package com.rental.service;

import com.rental.model.MovieCategory;
import com.rental.model.MovieRental;

public class RentalPriceServiceImpl implements RentalPriceService {
    private static final double BASE_AMOUNT = 1.5;
    private static final int BASE_DAYS = 3;
    private static final double EXTRA_DAY_RATE = 1.5;

    /**
     * {@inheritDoc}
     *
     * Calculates the rental price based on the movie category and rental days.
     */
    @Override
    public double calculateRentalPrice(MovieRental movieRental) {
        MovieCategory movieCategory = movieRental.getMovie().getMovieCategory();
        int daysRented = movieRental.getDaysRented();

        return switch (movieCategory) {
            case REGULAR -> calculateRegularPrice(daysRented);
            case NEW_RELEASE -> calculateNewReleasePrice(daysRented);
            case CHILDREN -> calculateChildrenPrice(daysRented);
        };
    }

    /**
     * {@inheritDoc}
     *
     * Calculates loyalty points based on the movie category and rental days.
     * New releases give extra points if rented for more than 2 days.
     */
    @Override
    public int calculateLoyaltyPoints(MovieRental movieRental) {
        int points = 1; //Base points for any movieRental

        if (movieRental.getMovie().getMovieCategory() == MovieCategory.NEW_RELEASE
                && movieRental.getDaysRented() > 2) {
            points++;
        }

        return points;
    }

    /**
     * Calculates the price for a regular movie rental.
     * Regular movies have a base price, and extra charges apply for rentals longer than 2 days.
     *
     * @param daysRented the number of days the movie was rented
     * @return the calculated price for the regular movie
     */
    private double calculateRegularPrice(int daysRented) {
        double price = BASE_AMOUNT + 0.5; //Since the original base price is 2.0
        if (daysRented > 2) {
            price += (daysRented - 2) * EXTRA_DAY_RATE;
        }
        return price;
    }

    /**
     * Calculates the price for a new release movie rental.
     * New releases have a fixed daily rental rate.
     *
     * @param daysRented the number of days the movie was rented
     * @return the calculated price for the new release movie
     */
    private double calculateNewReleasePrice(int daysRented) {
        return daysRented * 3.0;
    }

    /**
     * Calculates the price for a children's movie rental.
     * Children's movies have a lower base price, with extra charges for rentals longer than 3 days.
     *
     * @param daysRented the number of days the movie was rented
     * @return the calculated price for the children's movie
     */
    private double calculateChildrenPrice(int daysRented) {
        double price = BASE_AMOUNT;
        if (daysRented > BASE_DAYS) {
            price += (daysRented - BASE_DAYS) * EXTRA_DAY_RATE;
        }
        return price;
    }
}
