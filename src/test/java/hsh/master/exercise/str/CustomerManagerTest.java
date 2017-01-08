package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Customer;
import hsh.master.exercise.str.manager.CustomerManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Maren on 08.01.2017.
 */
public class CustomerManagerTest {

    private Address address;
    private Address address2;
    private Customer customer;
    private Customer customer2;
    private String name;
    private CustomerManager cm;

    @Before
    public void init() {
        cm = new CustomerManager();
        address = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        name = "Jane Doe";
    }

    @Test
    public void shouldCreateNewCustomer() {
        Address address = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        String name = "Jane Doe";
        customer = cm.createCustomer(name, address);
        assertEquals(address, customer.getAddress());
        assertEquals(name, customer.getName());
    }

    @Test
    public void cantInstantiateCustomersWithSameName() {
        address2 = new Address("de", "berlin", 10557, "Willy-Brandt-Straße", 1);
        customer = cm.createCustomer(name, address);
        customer2 = cm.createCustomer(name, address2);
        assertNotEquals(customer, customer2);
    }
}
