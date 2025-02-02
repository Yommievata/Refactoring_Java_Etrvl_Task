package com.rental.model;

public class Movie {
    private final Long id;
    private final String title;
    private final MovieCategory movieCategory;

    public Movie(Long id, String title, MovieCategory movieCategory) {

        this.id = id;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    @Override
    public String toString() {
        return String.format("model.Movie{id=%d, title='%s', movieCategory=%s}", id, title, movieCategory);
    }
}
