package hsh.master.exercise.str;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        BookingTest.class,
        CustomerTest.class,
        EventTest.class,
        ServicesTest.class,
        BlacklistTest.class,
        BookingManagerTest.class,
        CustomerManagerTest.class,
        EventManagerTest.class
})
public class AllTests {}