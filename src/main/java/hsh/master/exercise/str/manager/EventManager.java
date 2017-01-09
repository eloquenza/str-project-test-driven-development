package hsh.master.exercise.str.manager;

import hsh.master.exercise.str.entities.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager extends AbstractManager {

    private List<Event> events;

    public EventManager() {
        super("events.dat");
        events = new ArrayList<>();
    }

    public Event createEvent(String title, LocalDateTime dateAndTime, double price, int availableSeats, String orgMail) {
        Event e = new Event(title, dateAndTime, price, availableSeats, orgMail);
        events.add(e);
        return e;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public void persist() {
        this.persistEntities(events);
    }

    @Override
    public void load() {
        events = (List<Event>) this.loadEntities();
    }
}
