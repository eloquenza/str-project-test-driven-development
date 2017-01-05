package hsh.master.exercise.str;

import java.time.*;

public class Event {

    private int id;
    private String title;
    private LocalDateTime dateAndTime;
    private double price;
    private int availableSeats;

    public Event(int id, String title, LocalDateTime dateAndTime, double price, int availableSeats) {
        this.id = id;
    }

    public Event() {

    }

    public int getId() {
        return id;
    }

}