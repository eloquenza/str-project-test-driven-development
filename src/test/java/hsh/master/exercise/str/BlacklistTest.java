package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.exceptions.CustomerRejectionException;
import hsh.master.exercise.str.externalServices.Blacklist;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlacklistTest {

    @Rule public MockitoRule mockrule = MockitoJUnit.rule();
    @Mock private Blacklist bl;

    private Address a;
    private Customer c;

    private LocalDateTime eventDate;
    private Event e;
    private String eventName;
    private double eventPrice;
    private int eventSeats;

    private Services service;

    @Before
    public void init() {
        service = new Services();
        service.setBlacklist(bl);

        a = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        c = service.createNewCustomer("Maren Sandner", a);

        eventDate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        eventName = "concert1";
        eventPrice = 20.00;
        eventSeats = 100;
        e = service.createNewEvent(eventName, eventDate, eventPrice, eventSeats);
    }

    @Test(expected = CustomerRejectionException.class)
    public void shouldRejectBookingWhenCustomerIsOnBlacklist() throws CustomerRejectionException {
        when(bl.isOnBlacklist(anyString())).thenReturn(true);
        Booking b = service.bookAEvent(c, e, 10);
        verify(bl).isOnBlacklist(c.getName());
        assertNull(b);
    }

    @Test
    public void shouldAllowBookingWhenCustomerIsNotOnBlacklist() throws CustomerRejectionException {
        when(bl.isOnBlacklist(anyString())).thenReturn(false);
        Booking b = service.bookAEvent(c, e, 10);
        verify(bl).isOnBlacklist(c.getName());
        assertNotNull(b);
    }
}
