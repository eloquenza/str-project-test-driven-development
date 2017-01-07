package hsh.master.exercise.str.manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractManager {

    private String filename;

    public AbstractManager(String filename) {
        this.filename = filename;
    }

    protected void persistEntities(Object o) {
        try (FileOutputStream file = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(file)) {
            oos.writeObject(o);
        } catch (Exception e) {

        }
    }

    protected Object loadEntities() {
        Object o = null;
        try (FileInputStream file = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(file)) {
             o = ois.readObject();
        } catch (Exception ex) {

        }
        return o;
    }

    public abstract void persist();
    public abstract void load();
}
