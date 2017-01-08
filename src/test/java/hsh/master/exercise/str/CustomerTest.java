/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str;

import hsh.master.exercise.str.entities.Address;
import hsh.master.exercise.str.entities.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Address address1;
    private Customer customer1;
    private String name;

    @Before
    public void init() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        name = "Jane Doe";
        customer1 = new Customer(name, address1);
    }

    @Test
    public void shouldInstantiateCustomer() {
        // init does it all.
    }

    @Test
    public void customerShouldHaveName() {
        assertEquals(name, customer1.getName());
    }

    @Test
    public void customerShouldHaveAddress() {
        assertEquals(address1, customer1.getAddress());
    }
}
