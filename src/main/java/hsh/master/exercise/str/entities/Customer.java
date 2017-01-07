/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str.entities;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
