package hsh.master.exercise.str;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maren on 22.12.2016.
 */
public class AdressTest {

    @Test
    public void shouldInstantiateAdress() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
    }

    @Test
    public void AdressShouldHaveCountry() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        assertEquals("de", a.getCountry());
    }

    @Test
    public void AdressShouldHaveCity() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        assertEquals("hannover", a.getCity(), 0);
    }

    @Test
    public void AdressShouldHavZipcode() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        assertEquals(30459, a.getZipcode(), 0);
    }

    @Test
    public void AdressShouldHavStreet() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        assertEquals("Ricklinger Stadtweg", a.getStreet(), 0);
    }

    @Test
    public void AdressShouldHavHousenumber() {
        Adress a = new Adress("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        assertEquals(120, a.getHousenumber(), 0);
    }
}