/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerTest {

    private Address address1;
    private Customer customer1;
    private String name;
    private CustomerFactory cf;

    @Before
    public void init() {
        cf = new CustomerFactory();
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        name = "Jane Doe";
        customer1 = cf.createCustomer(name, address1);
    }

    @Test
    public void shouldInstantiateCustomer() {
        // init does it all.
    }

    @Test
    public void cantInstantiateCustomersWithSameName() {
        Address address2 = new Address("de", "berlin", 10557, "Willy-Brandt-Straße", 1);
        Customer customer2 = cf.createCustomer(name, address2);
        assertNotEquals(customer1, customer2);
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
