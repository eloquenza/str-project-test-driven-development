/**
 * Created by Maren on 22.12.2016.
 */
package hsh.master.exercise.str;

public class Customer {

    private String name;
    private Adress adress;

    public Customer(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public Adress getAdress() {
        return adress;
    }
}
