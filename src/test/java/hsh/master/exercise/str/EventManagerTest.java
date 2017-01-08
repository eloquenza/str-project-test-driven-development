package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.manager.EventManager;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maren on 08.01.2017.
 */
public class EventManagerTest {

    private EventManager em;
    private LocalDateTime eDate;
    private String eName;
    private int ePrice;
    private int eSeats;

    private Event e;

    @Before
    public void init() {
        em = new EventManager();
        eDate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        eName = "The Bangles";
        ePrice = 100;
        eSeats = 9000;

        e = em.createEvent(eName, eDate, ePrice, eSeats);
    }

    @Test
    public void shouldCreateEvent() {
        //init creates Event
        //checking if everything is set
        assertEquals(eName, e.getTitle());
        assertEquals(eDate, e.getDateAndTime());
        assertEquals(ePrice, e.getPrice(), 0);
        assertEquals(eSeats, e.getAvailableSeats());
    }

}


