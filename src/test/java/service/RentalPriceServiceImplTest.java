package service;

import com.rental.model.Customer;
import com.rental.model.Movie;
import com.rental.model.MovieCategory;
import com.rental.model.MovieRental;
import com.rental.service.RentalPriceService;
import com.rental.service.RentalPriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RentalPriceServiceImpl Tests")
class RentalPriceServiceImplTest {
    private RentalPriceService priceService;
    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        priceService = new RentalPriceServiceImpl();
        testCustomer = new Customer(1L, "Test Customer");
    }

    @ParameterizedTest(name = "Regular movie rental for {1} days should cost {2}")
    @CsvSource({
            "Regular Movie, 1, 2.0",
            "Regular Movie, 2, 2.0",
            "Regular Movie, 3, 3.5",
            "Regular Movie, 4, 5.0"
    })
    void calculateRegularMoviePriceTest(String title, int daysRented, double expectedPrice) {
        Movie movie = new Movie(1L, title, MovieCategory.REGULAR);
        MovieRental rental = new MovieRental(1L, movie, testCustomer, daysRented);

        double actualPrice = priceService.calculateRentalPrice(rental);

        assertEquals(expectedPrice, actualPrice,
                String.format("Regular movie for %d days should cost %.1f", daysRented, expectedPrice));
    }

    @ParameterizedTest(name = "New release rental for {1} days should cost {2}")
    @CsvSource({
            "New Movie, 1, 3.0",
            "New Movie, 2, 6.0",
            "New Movie, 3, 9.0"
    })
    void calculateNewReleasePrice(String title, int daysRented, double expectedPrice) {
        Movie movie = new Movie(1L, title, MovieCategory.NEW_RELEASE);
        MovieRental rental = new MovieRental(1L, movie, testCustomer, daysRented);

        double actualPrice = priceService.calculateRentalPrice(rental);

        assertEquals(expectedPrice, actualPrice,
                String.format("New release for %d days should cost %.1f", daysRented, expectedPrice));
    }

    @ParameterizedTest(name = "Children's movie rental for {1} days should cost {2}")
    @CsvSource({
            "Children Movie, 1, 1.5",
            "Children Movie, 3, 1.5",
            "Children Movie, 4, 3.0",
            "Children Movie, 5, 4.5"
    })
    void calculateChildrenMoviePrice(String title, int daysRented, double expectedPrice) {
        Movie movie = new Movie(1L, title, MovieCategory.CHILDREN);
        MovieRental rental = new MovieRental(1L, movie, testCustomer, daysRented);

        double actualPrice = priceService.calculateRentalPrice(rental);

        assertEquals(expectedPrice, actualPrice,
                String.format("Children's movie for %d days should cost %.1f", daysRented, expectedPrice));
    }

    @Test
    @DisplayName("Regular movie should earn basic loyalty points")
    void calculateLoyaltyPoints_RegularMovie() {
        Movie movie = new Movie(1L, "Regular Movie", MovieCategory.REGULAR);
        MovieRental rental = new MovieRental(1L, movie, testCustomer, 1);
        int expectedPoints = 1;

        int actualPoints = priceService.calculateLoyaltyPoints(rental);

        assertEquals(expectedPoints, actualPoints,
                "Regular movie should earn 1 loyalty point");
    }

    @ParameterizedTest(name = "New release rental for {0} days should earn {1} points")
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 2"
    })
    void calculateLoyaltyPoints_NewRelease(int daysRented, int expectedPoints) {
        Movie movie = new Movie(1L, "New Release", MovieCategory.NEW_RELEASE);
        MovieRental rental = new MovieRental(1L, movie, testCustomer, daysRented);

        int actualPoints = priceService.calculateLoyaltyPoints(rental);

        assertEquals(expectedPoints, actualPoints,
                String.format("New release for %d days should earn %d points", daysRented, expectedPoints));
    }
}
