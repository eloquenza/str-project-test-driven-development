package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.manager.BookingManager;
import hsh.master.exercise.str.manager.CustomerManager;
import hsh.master.exercise.str.manager.EventManager;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maren on 08.01.2017.
 */
public class BookingManagerTest {

    private BookingManager bm;
    private CustomerManager cm;
    private EventManager em;

    private LocalDateTime testdate;
    private Address address;
    private String name;

    private Booking b;
    private Booking b2;
    private Customer c;
    private Event e;

    @Before
    public void init() {
        bm = new BookingManager();
        cm = new CustomerManager();
        em = new EventManager();

        testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        address = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        name = "John Smith";

        c = cm.createCustomer(name, address);
        e = em.createEvent("concert", testdate, 20.00, 150, "example@mail.com");
        bm.manageCustomerInMap(c);
        b = bm.createBooking(c, e, 10);
    }

    @Test
    public void shouldCreateBooking() {
        assertEquals(c, b.getCustomer());
        assertEquals(e, b.getEvent());
        assertEquals(10, b.getBookedSeats());
    }

    @Test
    public void shouldSumUpBookingsForSameEventFromSameCustomer() {
        b2 = bm.createBooking(c, e, 20); //should set bookedSeats to 30
        Booking b3 = new Booking(30, c, e);

        assertEquals(b3.getBookedSeats(), bm.getBookingsForCustomer(c).get(e).getBookedSeats());


    }
}
