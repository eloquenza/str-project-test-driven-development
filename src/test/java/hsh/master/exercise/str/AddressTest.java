package hsh.master.exercise.str;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maren on 22.12.2016.
 */
public class AddressTest {

    private Address a;
    private String country;
    private String city;
    private int zipcode;
    private String street;
    private int housenumber;

    @Before
    public void init() {
        country = "DE";
        city = "Hannover";
        street = "Ricklinger Stadtweg";
        housenumber = 120;
        zipcode = 30159;
        a = new Address(country, city, zipcode, street, housenumber);
    }

    @Test
    public void shouldInstantiateAdress() {
        // init does it all
    }

    @Test
    public void AdressShouldHaveCountry() {
        assertEquals(country, a.getCountry());
    }

    @Test
    public void AdressShouldHaveCity() {
        assertEquals(city, a.getCity());
    }

    @Test
    public void AdressShouldHaveZipcode() {
        assertEquals(zipcode, a.getZipcode(), 0);
    }

    @Test
    public void AdressShouldHaveStreet() {
        assertEquals(street, a.getStreet());
    }

    @Test
    public void AdressShouldHaveHousenumber() {
        assertEquals(housenumber, a.getHousenumber(), 0);
    }
}