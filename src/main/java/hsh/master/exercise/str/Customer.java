/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str;

public class Customer {

    private String name;
    private Address address;


    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
