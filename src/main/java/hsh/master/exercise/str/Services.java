package hsh.master.exercise.str;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Maren on 23.12.2016.
 */
public class Services {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    CustomerFactory customerf = new CustomerFactory();

    public Customer createNewCustomer(String name, Address address) {
        Customer c = customerf.createCustomer(name, address);
        if(c != null) {
            customers.add(c);
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

    public Booking bookAEvent(Customer c, Event e, int bookedSeats) {
        e.reduceAvailableSeats(bookedSeats);
        return new Booking(bookedSeats, c, e);
    }
}
