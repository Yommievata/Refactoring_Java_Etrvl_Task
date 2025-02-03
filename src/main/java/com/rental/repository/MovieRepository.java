package com.rental.repository;

import com.rental.model.Movie;

public interface MovieRepository {
    /**
     * Saves a movie.
     * If the movie has no ID, a new one is assigned.
     *
     * @param movie the movie to save
     * @return the saved movie with an assigned ID if necessary
     */
    Movie save(Movie movie);
}
