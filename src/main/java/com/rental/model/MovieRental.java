package com.rental.model;

import java.time.LocalDateTime;

public class MovieRental {
    private final Long id;
    private final Movie movie;
    private final Customer customer;
    private final LocalDateTime rentalDate;
    private final int daysRented;

    public MovieRental(Long id, Movie movie, Customer customer, int daysRented) {
        this.id = id;
        this.movie = movie;
        this.customer = customer;
        this.rentalDate = LocalDateTime.now();
        this.daysRented = daysRented;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
