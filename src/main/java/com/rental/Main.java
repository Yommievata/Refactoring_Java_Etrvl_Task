package com.rental;

import com.rental.model.Customer;
import com.rental.model.Movie;
import com.rental.model.MovieCategory;
import com.rental.model.MovieRental;
import com.rental.repository.CustomerRepository;
import com.rental.repository.CustomerRepositoryImpl;
import com.rental.repository.MovieRepository;
import com.rental.repository.MovieRepositoryImpl;
import com.rental.repository.MovieRentalRepository;
import com.rental.repository.MovieRentalRepositoryImpl;
import com.rental.service.RentalPriceService;
import com.rental.service.RentalPriceServiceImpl;
import com.rental.service.RentalStatementService;
import com.rental.service.RentalStatementServiceImpl;

public class Main {

  public static void main(String[] args) {
    MovieRepository movieRepo = new MovieRepositoryImpl();
    CustomerRepository customerRepo = new CustomerRepositoryImpl();
    MovieRentalRepository rentalRepo = new MovieRentalRepositoryImpl();

    RentalPriceService priceService = new RentalPriceServiceImpl();
    RentalStatementService statementService = new RentalStatementServiceImpl(priceService);

    //create same data to mimic initial code
    Movie movie1 = movieRepo.save(new Movie(null, "You've Got Mail", MovieCategory.REGULAR));
    Movie movie2 = movieRepo.save(new Movie(null, "Matrix", MovieCategory.REGULAR));

    Customer customer = customerRepo.save(new Customer(null, "C. U. Stomer"));

    MovieRental rental1 = new MovieRental(null, movie1, customer, 3);
    MovieRental rental2 = new MovieRental(null, movie2, customer, 1);

    rental1 = rentalRepo.save(rental1);
    rental2 = rentalRepo.save(rental2);

    customer.addMovieRental(rental1);
    customer.addMovieRental(rental2);

    String statement = statementService.generateStatement(customer);
    System.out.println(statement);

    // Verify output using text block form
    String expected = """
            Rental Record for C. U. Stomer
            \tYou've Got Mail\t3.5
            \tMatrix\t2.0
            Amount owed is 5.5
            You earned 2 loyalty points
            """;

    if (!statement.equals(expected)) {
      throw new AssertionError("Expected:\n" + expected + "\nGot:\n" + statement);
    }

    System.out.println("Success!!!");
  }
}
