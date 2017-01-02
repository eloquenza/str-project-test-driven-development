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

    /*  original refactoring idea but the tests need different customers,
        since same customers are not allowed
    @Before
    public void init() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        customer1 = new Customer("Maren Sandner", address1);
    }*/

    @Test
    public void shouldInstantiateCustomer() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        customer1 = new Customer("Maren Sandner", address1);
    }


    @Test
    public void cantInstantiateCustomersWithSameName() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        customer1 = new Customer("Test", address1);
        Address address2 = new Address("de", "berlin", 10557, "Willy-Brandt-Straße", 1);
        Customer customer2 = new Customer("Test", address2);
        assertNotEquals(address2, customer2.getAddress());
    }

    @Test
    public void customerShouldHaveName() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        customer1 = new Customer("Test1", address1);
        assertEquals("Test1", customer1.getName());
    }

    @Test
    public void customerShouldHaveAddress() {
        address1 = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        customer1 = new Customer("Test2", address1);
        assertEquals(address1, customer1.getAddress());
    }



}
