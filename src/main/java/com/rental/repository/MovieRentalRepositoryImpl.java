package com.rental.repository;

import com.rental.model.MovieRental;

public class MovieRentalRepositoryImpl implements MovieRentalRepository {
    private Long nextId = 1L;

    @Override
    public MovieRental save(MovieRental rental) {
        if (rental.getId() == null) {
            return new MovieRental(
                    nextId++,
                    rental.getMovie(),
                    rental.getCustomer(),
                    rental.getDaysRented()
            );
        }
        return rental;
    }
}
