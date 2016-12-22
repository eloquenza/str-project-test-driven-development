/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);

    @Test
    public void shouldInstantiateCustomer() {
       Customer c = new Customer("Maren Sandner", a);
    }

    @Test
    public void customerShouldHaveName() {
        Customer c = new Customer("Maren Sandner", a);
        assertEquals("Maren Sandner", c.getName());
    }

    @Test
    public void customerShouldHaveAdress() {
        Customer c = new Customer("Maren Sandner", a);
        assertEquals(a, c.getAdress());
    }



}
