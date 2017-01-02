package hsh.master.exercise.str;

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
}
