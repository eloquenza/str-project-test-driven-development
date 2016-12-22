package hsh.master.exercise.str;


import java.util.UUID;

/**
 * Created by Maren on 22.12.2016.
 */
public class Booking {

    private UUID id;
    private int bookedSeats;

    public Booking(UUID id, int bookedSeats) {
        this.id = id;
        this.bookedSeats = bookedSeats;
    }

    public UUID getId() {
        return id;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }
}
