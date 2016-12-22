package hsh.master.exercise.str;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Maren on 22.12.2016.
 */
public class BookingTest {

    UUID id = UUID.randomUUID();

    @Test
    public void shouldInstantiateBooking() {
        Booking b = new Booking(id, 12);
    }


    @Test
    public void bookingShouldHaveId() {
        Booking b = new Booking(id, 12);
        assertEquals(id, b.getId());
    }

    @Test
    public void bookingShouldHaveBookedSeats() {
        Booking b = new Booking(id, 12);
        assertEquals(12, b.getBookedSeats());
    }
}