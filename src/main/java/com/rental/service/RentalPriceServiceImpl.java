package com.rental.service;

import com.rental.model.MovieCategory;
import com.rental.model.MovieRental;

public class RentalPriceServiceImpl implements RentalPriceService {
    private static final double BASE_AMOUNT = 1.5;
    private static final int BASE_DAYS = 3;
    private static final double EXTRA_DAY_RATE = 1.5;

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

    @Override
    public int calculateLoyaltyPoints(MovieRental movieRental) {
        int points = 1; //Base points for any movieRental

        if (movieRental.getMovie().getMovieCategory() == MovieCategory.NEW_RELEASE
                && movieRental.getDaysRented() > 2) {
            points++;
        }

        return points;
    }

    private double calculateRegularPrice(int daysRented) {
        double price = BASE_AMOUNT + 0.5; //Since the original base price is 2.0
        if (daysRented > 2) {
            price += (daysRented - 2) * EXTRA_DAY_RATE;
        }
        return price;
    }

    private double calculateNewReleasePrice(int daysRented) {
        return daysRented * 3.0;
    }

    private double calculateChildrenPrice(int daysRented) {
        double price = BASE_AMOUNT;
        if (daysRented > BASE_DAYS) {
            price += (daysRented - BASE_DAYS) * EXTRA_DAY_RATE;
        }
        return price;
    }
}
