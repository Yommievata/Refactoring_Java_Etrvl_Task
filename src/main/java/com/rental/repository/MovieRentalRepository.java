package com.rental.repository;

import com.rental.model.MovieRental;

public interface MovieRentalRepository {
    /**
     * Saves a movie rental.
     * If the rental has no ID, a new one is assigned.
     *
     * @param rental the movie rental to save
     * @return the saved movie rental with an assigned ID if necessary
     */
    MovieRental save(MovieRental rental);
}
