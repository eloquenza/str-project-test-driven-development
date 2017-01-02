package hsh.master.exercise.str;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class EventTest {

    LocalDateTime testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);


    @Test
    public void shouldInstantiateEvent() {
        Event e = new Event("concert1", testdate, 20.00, 100);
    }

    @Test
    public void eventShouldHaveID() {
       Event e = new Event("test", testdate, 10.00, 100);
        //TODO
        assertEquals(e.getDateAndTime(), testdate);
    }

    @Test
    public void shouldReduceAvailableSeats() {
        Event e = new Event("test", testdate, 10.00, 100);
        e.reduceAvailableSeats(10);

        assertEquals(90, e.getAvailableSeats());
    }
}