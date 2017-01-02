package hsh.master.exercise.str;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Maren on 23.12.2016.
 */
public class ServicesTest {

    private Services service = new Services();
    LocalDateTime testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
    Address address = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);


    @Test
    public void shouldCreateNewCustomer() {
        Customer c = service.createNewCustomer("Maren", address);

        assertEquals("Maren", c.getName());
        assertEquals(address, c.getAddress());
    }

    @Test
    public void shouldCreateNewEvent() {
        Event e = service.createNewEvent("test", testdate, 10.00, 100);
        assertEquals(10.00, e.getPrice(), 0);
    }

    @Test
    public void shouldListAllEvents() {
        Event e1 = service.createNewEvent("Konzert1", testdate, 1.5, 20);
        Event e2 = service.createNewEvent("Konzert2", testdate, 15, 50);
        Event e3 = service.createNewEvent("Konzert3", testdate, 10.5, 52);

        ArrayList<Event> testevents = new ArrayList<>();
        testevents.add(e1);
        testevents.add(e2);
        testevents.add(e3);

        assertEquals(testevents, service.listAllEvents());
    }

    @Test
    public void shouldGetAvailableSeatsForAEvent() {
        Event e = service.createNewEvent("test", testdate, 10.00, 100);

        assertEquals(100, service.getAvailableSeatsForAEvent(e));
    }

    @Test
    public void shouldListALlCustomers() {
        Customer c1 = service.createNewCustomer("Maren", address);
        Customer c2 = service.createNewCustomer("Dennis", address);
        Customer c3 = service.createNewCustomer("Dino", address);

        ArrayList<Customer> testcustomers= new ArrayList<>();
        testcustomers.add(c1);
        testcustomers.add(c2);
        testcustomers.add(c3);

        assertEquals(testcustomers, service.listAllCustomers());
    }

    @Test
    public void shouldCreateBooking() {
        Customer c = service.createNewCustomer("Maren", address);
        Event e = service.createNewEvent("test", testdate, 10.00, 100);
        service.bookAEvent(c, e, 5);
        assertEquals(95, e.getAvailableSeats());

    }
}