package com.rental.repository;

import com.rental.model.MovieRental;

public interface MovieRentalRepository {
    MovieRental save(MovieRental rental);
}
