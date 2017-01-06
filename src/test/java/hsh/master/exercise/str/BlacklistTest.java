package hsh.master.exercise.str;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlacklistTest {

    @Rule public MockitoRule mockrule = MockitoJUnit.rule();
    @Mock private Blacklist bl;

    @Test
    public void shouldRejectBookingWhenCustomerIsOnBlacklist() {
        when(bl.isOnBlacklist(anyString())).thenReturn(true);
        Address a = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        Customer c = new Customer("Maren Sandner", a);
        assertTrue(bl.isOnBlacklist(c.getName()));
        verify(bl).isOnBlacklist(c.getName());
    }

}
