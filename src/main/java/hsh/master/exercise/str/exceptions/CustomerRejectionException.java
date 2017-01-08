package hsh.master.exercise.str.exceptions;

import hsh.master.exercise.str.entities.Customer;

public class CustomerRejectionException extends Exception {
    public CustomerRejectionException(Customer c) {
        super("The customer " + c.getName() + " tried to create a booking, but is on a blacklist.");
    }
}
