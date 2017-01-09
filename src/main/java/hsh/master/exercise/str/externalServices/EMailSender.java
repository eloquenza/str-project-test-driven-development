package hsh.master.exercise.str.externalServices;

import hsh.master.exercise.str.entities.Booking;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.entities.Event;

public interface EMailSender {

    public boolean sendMail(Customer c, Event e, Booking b);
}
