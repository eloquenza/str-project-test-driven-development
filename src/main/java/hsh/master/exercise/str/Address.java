package hsh.master.exercise.str;

import java.util.Objects;

/**
 * Created by Maren on 22.12.2016.
 */
public class Address {

    private String country; //should be in the format "de", "us" etc.
    private String city;
    private int zipcode;
    private String street;
    private int housenumber;

    public Address(String country, String city, int zipcode, String street, int housenumber) {
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.housenumber = housenumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return getZipcode() == address.getZipcode() &&
                getHousenumber() == address.getHousenumber() &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getZipcode(), getStreet(), getHousenumber());
    }
}
