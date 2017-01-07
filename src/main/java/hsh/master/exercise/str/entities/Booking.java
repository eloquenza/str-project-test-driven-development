package hsh.master.exercise.str.entities;


import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Maren on 22.12.2016.
 */
public class Booking implements Serializable {


    private UUID id;
    private int bookedSeats;
    private Customer c;
    private Event e;

    public Booking(int bookedSeats, Customer c, Event e) {
        this.id = UUID.randomUUID();
        this.bookedSeats = bookedSeats;
        this.c = c;
        this.e = e;
        System.out.println("Created new Booking");
    }

    public UUID getId() {
        return id;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public Customer getCustomer() {
        return c;
    }

    public Event getEvent() {
        return e;
    }
}
