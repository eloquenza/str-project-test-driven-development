package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.exceptions.CustomerRejectionException;
import hsh.master.exercise.str.externalServices.EMailSender;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EMailSenderTest {

    @Rule
    public MockitoRule mockrule = MockitoJUnit.rule();
    @Mock
    private EMailSender ems;

    private Address a;
    private Customer c;

    private LocalDateTime eventDate;
    private Event e;
    private String eventName;
    private double eventPrice;
    private int eventSeats;
    private String orgMail;

    private Services service;

    @Before
    public void init() {
        service = new Services();
        service.setEMailSender(ems);

        a = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        c = service.createNewCustomer("Maren Sandner", a);

        eventDate = LocalDateTime.of(2016, Month.DECEMBER, 24, 23, 23, 23);
        eventName = "concert1";
        eventPrice = 20.00;
        eventSeats = 100;
        orgMail = "example@mail.com";
        e = service.createNewEvent(eventName, eventDate, eventPrice, eventSeats, orgMail);
    }

    @Test
    public void mailShouldBeSentIfCustomerBooksMoreThanTenPercentOfTotalSeats() throws CustomerRejectionException {
        when(ems.sendMail(any(Customer.class), any(Event.class), any(Booking.class))).thenReturn(true);
        // 20 seats are 20% of 100 seats, should trigger an email
        Booking b = service.bookAEvent(c, e, 20);
        verify(ems).sendMail(c, e, b);
    }

    @Test
    public void MailShouldNotBeSentIfBookedSeatsAreUnder10Percent() throws CustomerRejectionException {
        when(ems.sendMail(any(Customer.class), any(Event.class), any(Booking.class))).thenReturn(true);
        // 9 seats are 9%, should NOT trigger
        Booking b = service.bookAEvent(c, e, 9);
        verify(ems, never()).sendMail(c, e, b);
    }
}
