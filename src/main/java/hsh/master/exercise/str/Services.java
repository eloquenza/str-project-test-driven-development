package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;
import hsh.master.exercise.str.exceptions.NotEnoughSeatsException;
import hsh.master.exercise.str.manager.BookingManager;
import hsh.master.exercise.str.manager.CustomerManager;
import hsh.master.exercise.str.manager.EventManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maren on 23.12.2016.
 */
public class Services {

    private CustomerManager cm;
    private EventManager em;
    private BookingManager bm;

    public Services() {
        cm = new CustomerManager();
        em = new EventManager();
        bm = new BookingManager();
    }

    public Customer createNewCustomer(String name, Address address) {
        Customer c = cm.createCustomer(name, address);
        if(c != null) {
            bm.manageCustomerInMap(c);
        }
        return c;
    }

    public Event createNewEvent(String title, LocalDateTime dateAndTime, double price, int availableSeats) {
        return em.createEvent(title, dateAndTime, price, availableSeats);
    }

    public Booking createNewBooking(Customer c, Event e, int bookedSeats) throws NotEnoughSeatsException {
        return bm.createBooking(c, e, bookedSeats);
    }

    public List<Event> listAllEvents() {
        return em.getEvents();
    }

    public int getAvailableSeatsForAEvent(Event e) {
        return e.getAvailableSeats();
    }

    public List<Customer> listAllCustomers() {
        return cm.getCustomers();
    }

    public Booking bookAEvent(Customer c, Event e, int bookedSeats) throws NotEnoughSeatsException {
        Booking b = createNewBooking(c, e, bookedSeats);
        return b;
    }

    public Booking getBooking(Customer c, Event e) {
        return bm.getBookingsForCustomer(c).get(e);
    }

    public void persistAllEntities() {
        bm.persist();
        cm.persist();
        em.persist();
    }

    public void loadAllEntities() {
        bm.load();
        cm.load();
        em.load();
    }
}
