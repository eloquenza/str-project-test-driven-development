package hsh.master.exercise.str.manager;

import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BookingManager extends AbstractManager {

    private Map<Customer, Map<Event, Booking>> bookingMap;

    public BookingManager() {
        super("bookings.dat");
        bookingMap = new HashMap<>();
    }

    public Booking createBooking(Customer c, Event e, int bookedSeats) {
        e.reduceAvailableSeats(bookedSeats);
        Map<Event, Booking> customerBookingMap = bookingMap.get(c);
        if (customerBookingMap.containsKey(e)) {
            int previouslyBookedSeats = customerBookingMap.get(e).getBookedSeats();
            bookedSeats += previouslyBookedSeats;
        }
        Booking b = new Booking(bookedSeats, c, e);
        customerBookingMap.put(e, b);
        return b;
    }

    public void manageCustomerInMap(Customer c) {
        bookingMap.put(c, new HashMap<>());
    }

    public Map<Event, Booking> getBookingsForCustomer(Customer c) {
        return Collections.unmodifiableMap(bookingMap.get(c));
    }

    @Override
    public void persist() {
        this.persistEntities(bookingMap);
    }

    @Override
    public void load() {
        bookingMap = (Map<Customer, Map<Event, Booking>>) this.loadEntities();
    }
}
