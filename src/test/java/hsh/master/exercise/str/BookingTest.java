package hsh.master.exercise.str;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Maren on 22.12.2016.
 */
public class BookingTest {

    private LocalDateTime testdate;
    private Address address1;
    private Customer c;
    private Event e;
    private Booking b;
    private int bookedSeats;

    @Before
    public void init() {
        testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        c = new Customer("Maren Sandner", address1);
        e = new Event("concert1", testdate, 20.00, 100);
        bookedSeats = 12;
        b = new Booking(bookedSeats, c, e);
    }

    @Test
    public void shouldInstantiateBooking() {
        // done by init
    }

    @Test
    public void bookingShouldHaveBookedSeats() {
        assertEquals(bookedSeats, b.getBookedSeats());
    }

    @Test
    public void bookingShouldHaveCustomer() {
        assertEquals(c, b.getCustomer());
    }

    @Test
    public void bookingShouldHaveEvent() {
        assertEquals(e, b.getEvent());
    }
}