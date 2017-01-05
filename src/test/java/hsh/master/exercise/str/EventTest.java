package hsh.master.exercise.str;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void shouldInstantiateEvent() {
        Event e = new Event();
    }

    @Test
    public void eventShouldHaveID() {
        LocalDateTime testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        Event e = new Event(1, "test", testdate, 10.00, 100);
        assertEquals("Must have an valid id", e.getId(), 1);
    }
}
