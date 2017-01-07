package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.exceptions.NotEnoughSeatsException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class EventTest {

    private LocalDateTime eventDate;
    private Event e;
    private String eventName;
    private double eventPrice;
    private int eventSeats;


    @Before
    public void init() {
        eventDate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        eventName = "concert1";
        eventPrice = 20.00;
        eventSeats = 100;
        e = new Event(eventName, eventDate, eventPrice, eventSeats);
    }

    @Test
    public void shouldInstantiateEvent() {
        // init does it all.
    }

    @Test
    public void eventShouldHaveID() {
        assertNotNull(e.getId());
    }

    @Test
    public void eventShouldHavePrice() {
        assertEquals(e.getPrice(), eventPrice, 0.0);
    }

    @Test
    public void eventShouldHaveADateAndTime() {
        assertEquals(eventDate, e.getDateAndTime());
    }

    @Test
    public void eventShouldAvailableSeats() {
        assertEquals(eventSeats, e.getAvailableSeats());
    }

    @Test
    public void shouldReduceAvailableSeats() {
        e.reduceAvailableSeats(10);
        assertEquals((eventSeats - 10), e.getAvailableSeats());
    }

    @Test(expected = NotEnoughSeatsException.class)
    public void cannotReduceAvailableSeatsByMoreThanAvailable() {
        e.reduceAvailableSeats(eventSeats+1);
        assertFalse(e.getAvailableSeats() < 0);
    }
}
