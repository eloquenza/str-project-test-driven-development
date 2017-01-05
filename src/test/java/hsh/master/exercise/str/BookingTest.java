package hsh.master.exercise.str;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Maren on 22.12.2016.
 */
public class BookingTest {


    LocalDateTime testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
    Address address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);

    Customer c = new Customer("Maren Sandner", address1);
    Event e = new Event("concert1", testdate, 20.00, 100);

    @Test
    public void shouldInstantiateBooking() {
        Booking b = new Booking(12, c, e);
    }

    @Test
    public void bookingShouldHaveBookedSeats() {
        Booking b = new Booking(12, c, e);
        assertEquals(12, b.getBookedSeats());
    }

    @Test
    public void bookingShouldHaveCustomer() {
        Booking b = new Booking(5, c, e);
        assertEquals(c, b.getCustomer());
    }

    @Test
    public void bookingShouldHaveEvent() {
        Booking b = new Booking(5, c, e);
        assertEquals(e, b.getEvent());
    }
}