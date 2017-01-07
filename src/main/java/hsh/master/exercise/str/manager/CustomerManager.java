package hsh.master.exercise.str.manager;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.manager.AbstractManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maren on 01.01.2017.
 */
public class CustomerManager extends AbstractManager {

    private Set<String> names;
    private List<Customer> customers;

    public CustomerManager() {
        super("customers.dat");
        names = new HashSet<>();
        customers = new ArrayList<>();
    }

    public Customer createCustomer(String name, Address address) {
        if (names.add(name)) {
            Customer c = new Customer(name, address);
            customers.add(c);
            return c;
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void persist() {
        this.persistEntities(customers);
    }

    @Override
    public void load() {
        customers = (List<Customer>) this.loadEntities();
    }
}
