package hsh.master.exercise.str;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maren on 01.01.2017.
 */
public class CustomerFactory {

    private Set<String> names;

    public CustomerFactory() {
        names = new HashSet<>();
    }

    public Customer createCustomer(String name, Address address) {
        if (names.add(name)) {
            System.out.println("Customer created");
            return new Customer(name, address);
        } else {
            System.out.println("Customer was not created, already exists");
            return null;
        }
    }
}
