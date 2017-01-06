package hsh.master.exercise.str;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlacklistTest {

    @Rule public MockitoRule mockrule = MockitoJUnit.rule();
    @Mock private Blacklist bl;

    private Address a;
    private Customer c;

    @Before
    public void init() {
        a = new Address("de", "hannover", 30459, "Ricklinger Stadtweg", 120);
        c = new Customer("Maren Sandner", a);
    }

    @Test
    public void shouldRejectBookingWhenCustomerIsOnBlacklist() {
        when(bl.isOnBlacklist(anyString())).thenReturn(true);
        assertTrue(bl.isOnBlacklist(c.getName()));
        verify(bl).isOnBlacklist(c.getName());
    }

    @Test
    public void shouldAllowBookingWhenCustomerIsNotOnBlacklist() {
        when(bl.isOnBlacklist(anyString())).thenReturn(false);
        assertFalse(bl.isOnBlacklist(c.getName()));
        verify(bl).isOnBlacklist(c.getName());
    }
}
