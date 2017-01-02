package hsh.master.exercise.str;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Dennis on 24.12.2016.
 */
public class Event {

    private UUID id;
    private String title;
    private LocalDateTime dateAndTime;
    private double price;
    private int availableSeats;

    public Event(String title, LocalDateTime dateAndTime, double price, int availableSeats) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.price = price;
        this.availableSeats = availableSeats;
        System.out.println("Event was created");
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void reduceAvailableSeats(int r) {
        if(availableSeats - r <= 0) {
            availableSeats = 0;
        } else {
            availableSeats = availableSeats- r;
        }
    }
}

