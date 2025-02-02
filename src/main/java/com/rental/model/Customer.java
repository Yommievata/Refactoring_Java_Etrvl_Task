package com.rental.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final Long id;
    private final String name;
    private final List<MovieRental> movieRental;
    private int loyaltyPoints;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.movieRental = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MovieRental> getMovieRental() {
        return new ArrayList<>(movieRental);
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addMovieRental(MovieRental movieRental) {
        this.movieRental.add(movieRental);
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }
}
