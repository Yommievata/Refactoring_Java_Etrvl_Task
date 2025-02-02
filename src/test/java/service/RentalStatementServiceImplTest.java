package service;

import com.rental.model.Customer;
import com.rental.model.Movie;
import com.rental.model.MovieCategory;
import com.rental.model.MovieRental;
import com.rental.service.RentalPriceService;
import com.rental.service.RentalPriceServiceImpl;
import com.rental.service.RentalStatementService;
import com.rental.service.RentalStatementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RentalStatementServiceImpl Tests")
class RentalStatementServiceImplTest {
    private RentalStatementService statementService;
    private Customer customer;

    @BeforeEach
    void setUp() {
        RentalPriceService priceService = new RentalPriceServiceImpl();
        statementService = new RentalStatementServiceImpl(priceService);
        customer = new Customer(1L, "Test Customer");
    }

    @Test
    @DisplayName("Generate statement for single regular movie rental")
    void generateStatement_SingleRegularMovie() {
        Movie movie = new Movie(1L, "Matrix", MovieCategory.REGULAR);
        MovieRental rental = new MovieRental(1L, movie, customer, 1);
        customer.addMovieRental(rental);

        String expected = """
            Rental Record for Test Customer
            \tMatrix\t2.0
            Amount owed is 2.0
            You earned 1 loyalty points
            """;

        String result = statementService.generateStatement(customer);

        assertEquals(expected, result, "Statement should match expected format and values");
    }

    @Test
    @DisplayName("Generate statement for multiple movie rentals")
    void generateStatement_MultipleMovies() {
        Movie movie1 = new Movie(1L, "Matrix", MovieCategory.REGULAR);
        Movie movie2 = new Movie(2L, "Avengers", MovieCategory.NEW_RELEASE);
        Movie movie3 = new Movie(3L, "Cars", MovieCategory.CHILDREN);

        customer.addMovieRental(new MovieRental(1L, movie1, customer, 2));
        customer.addMovieRental(new MovieRental(2L, movie2, customer, 3));
        customer.addMovieRental(new MovieRental(3L, movie3, customer, 4));

        String expected = """
            Rental Record for Test Customer
            \tMatrix\t2.0
            \tAvengers\t9.0
            \tCars\t3.0
            Amount owed is 14.0
            You earned 4 loyalty points
            """;

        String result = statementService.generateStatement(customer);

        assertEquals(expected, result, "Statement should match expected format and values for multiple rentals");
    }

    @Test
    @DisplayName("Generate statement for customer with no rentals")
    void generateStatement_NoMovieRentals() {
        String expected = """
            Rental Record for Test Customer
            Amount owed is 0.0
            You earned 0 loyalty points
            """;

        String result = statementService.generateStatement(customer);

        assertEquals(expected, result, "Statement should show zero amounts for customer with no rentals");
    }

    @Test
    @DisplayName("Generate statement for extended rental periods")
    void generateStatement_ExtendedRentals() {
        Movie movie1 = new Movie(1L, "Matrix", MovieCategory.REGULAR);
        Movie movie2 = new Movie(2L, "Finding Nemo", MovieCategory.CHILDREN);

        customer.addMovieRental(new MovieRental(1L, movie1, customer, 5));
        customer.addMovieRental(new MovieRental(2L, movie2, customer, 7));

        String expected = """
            Rental Record for Test Customer
            \tMatrix\t6.5
            \tFinding Nemo\t7.5
            Amount owed is 14.0
            You earned 2 loyalty points
            """;

        String result = statementService.generateStatement(customer);

        assertEquals(expected, result, "Statement should correctly calculate extended rental periods");
    }
}
