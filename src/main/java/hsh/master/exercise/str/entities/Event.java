package hsh.master.exercise.str.entities;

import hsh.master.exercise.str.exceptions.NotEnoughSeatsException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Dennis on 24.12.2016.
 */
public class Event implements Serializable {

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
        if (availableSeats - r < 0) {
            throw new NotEnoughSeatsException(availableSeats, r);
        } else {
            availableSeats = availableSeats - r;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(getId(), event.getId()) &&
                Objects.equals(getTitle(), event.getTitle()) &&
                Objects.equals(getDateAndTime(), event.getDateAndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDateAndTime());
    }
}