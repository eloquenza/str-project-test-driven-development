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
    private int totalSeats;
    private String organizerMail;

    public Event(String title, LocalDateTime dateAndTime, double price, int availableSeats, String organizerMail) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.totalSeats = availableSeats;
        this.organizerMail = organizerMail;
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

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getOrganizerMail() {
        return organizerMail;
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