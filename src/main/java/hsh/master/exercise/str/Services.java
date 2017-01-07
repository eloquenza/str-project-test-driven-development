package hsh.master.exercise.str;

import hsh.master.exercise.str.exceptions.NotEnoughSeatsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Maren on 23.12.2016.
 */
public class Services {

    private Map<Customer, Map<Event, Booking>> bookingMap;
    private ArrayList<Customer> customers;
    private ArrayList<Event> events;
    CustomerFactory customerf;

    public Services() {
        bookingMap = new HashMap<>();
        customers = new ArrayList<>();
        events = new ArrayList<>();
        customerf = new CustomerFactory();
    }

    public Customer createNewCustomer(String name, Address address) {
        Customer c = customerf.createCustomer(name, address);
        if(c != null) {
            customers.add(c);
            bookingMap.put(c, new HashMap<>());
            System.out.println("Customer was added to the list");
        }
        return c;
    }

    public Event createNewEvent(String title, LocalDateTime dateAndTime, double price, int availableSeats) {
        Event e = new Event(title, dateAndTime, price, availableSeats);
        events.add(e);
        System.out.println("Event was added to the list");

        return e;
    }

    public Booking createNewBooking(Customer c, Event e, int bookedSeats) throws NotEnoughSeatsException {
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

    public ArrayList<Event> listAllEvents() {
        for(Event e : events) {
            System.out.println(e.getTitle());
        }
        return events;
    }

    public int getAvailableSeatsForAEvent(Event e) {
        return e.getAvailableSeats();
    }

    public ArrayList<Customer> listAllCustomers() {
        for(Customer c : customers) {
            System.out.println(c.getName());
        }
        return customers;
    }

    public Booking bookAEvent(Customer c, Event e, int bookedSeats) throws NotEnoughSeatsException {
        Booking b = createNewBooking(c, e, bookedSeats);
        return b;
    }

    public Booking getBooking(Customer c, Event e) {
        return bookingMap.get(c).get(e);
    }
}
