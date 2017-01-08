package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.exceptions.CustomerRejectionException;
import org.junit.Before;
import org.junit.Test;
import hsh.master.exercise.str.exceptions.NotEnoughSeatsException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Maren on 23.12.2016.
 */
public class ServicesTest {

    private Services service;

    private Address address;
    private String cName;
    private Customer c;

    private String eName;
    private int eSeats;
    private double ePrice;
    private Event e;
    private LocalDateTime testdate;


    @Before
    public void init() {
        service = new Services();

        address = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        cName = "Jane Doe";
        c = service.createNewCustomer(cName, address);

        testdate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        eName = "Testevent";
        eSeats = 100;
        ePrice = 10.00;
        e = service.createNewEvent(eName, testdate, ePrice, eSeats);
    }

    @Test
    public void shouldCreateNewCustomer() {
        assertEquals(cName, c.getName());
        assertEquals(address, c.getAddress());
    }

    @Test
    public void shouldCreateNewEvent() {
        assertEquals(10.00, e.getPrice(), 0);
    }

    @Test
    public void shouldListAllEvents() {
        Event e1 = service.createNewEvent("Konzert1", testdate, 1.5, 20);
        Event e2 = service.createNewEvent("Konzert2", testdate, 15, 50);
        Event e3 = service.createNewEvent("Konzert3", testdate, 10.5, 52);

        ArrayList<Event> testevents = new ArrayList<>(Arrays.asList(e, e1, e2, e3));

        assertEquals(testevents, service.listAllEvents());
    }

    @Test
    public void shouldGetAvailableSeatsForAEvent() {
        assertEquals(100, service.getAvailableSeatsForAEvent(e));
    }

    @Test
    public void shouldListAllCustomers() {
        Customer c1 = service.createNewCustomer("Maren", address);
        Customer c2 = service.createNewCustomer("Dennis", address);
        Customer c3 = service.createNewCustomer("Dino", address);

        ArrayList<Customer> testcustomers= new ArrayList<>(Arrays.asList(c, c1, c2, c3));

        assertEquals(testcustomers, service.listAllCustomers());
    }

    @Test
    public void shouldCreateBooking() throws CustomerRejectionException {
        int seatsToBook = eSeats - 5;
        service.bookAEvent(c, e, seatsToBook);
        assertEquals(eSeats - seatsToBook, e.getAvailableSeats());
    }

    @Test(expected = NotEnoughSeatsException.class)
    public void userCannotBookMoreSeatsThanAvailable() throws CustomerRejectionException {
        service.bookAEvent(c, e, eSeats+1);
    }

    @Test
    public void shouldFindBookingForSpecificUserAndEvent() throws CustomerRejectionException {
        Booking b = service.bookAEvent(c, e, 5);
        assertEquals(service.getBooking(c, e), b);
    }

    @Test
    public void shouldNotFindBookingIfUserDidNotBookForSpecificEvent() {
        assertEquals(service.getBooking(c, e), null);
    }

    @Test
    public void bookingIsMergedWhenUserCreatesNewBookingForSameEvent() throws CustomerRejectionException {
        Booking b1 = service.bookAEvent(c, e, 5);
        Booking b2 = service.bookAEvent(c, e, 10);
        Booking saved = service.getBooking(c, e);
        assertEquals(15, saved.getBookedSeats());
        assertNotEquals(b1.getId(), b2.getId());
        assertEquals(b2.getId(), saved.getId());
    }

    @Test
    public void entitiesShouldBePersisted() throws CustomerRejectionException {
        Booking b = service.bookAEvent(c, e, 5);
        service.persistAllEntities();
    }

    @Test
    public void entitiesCanBeReloaded() {
        service.loadAllEntities();
    }
}