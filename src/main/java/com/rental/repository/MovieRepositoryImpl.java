package com.rental.repository;

import com.rental.model.Movie;

public class MovieRepositoryImpl implements MovieRepository {
    private Long nextId = 1L;

    @Override
    public Movie save(Movie movie) {
        if (movie.getId() == null) {
            return new Movie(nextId++, movie.getTitle(), movie.getMovieCategory());
        }
        return movie;
    }
}
