package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StashTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAmount() throws Exception {
        Stash stash = new Stash();
        assertEquals(1000,stash.getAmount());
    }

    @Test
    public void addAmount() throws Exception {
        Stash stash = new Stash();
        assertEquals(1000,stash.getAmount());
        //Vi sætter vores forventede amount til 1400, og prøver så at bruge addAmount(400)
        stash.addAmount(400);
        assertEquals(1400,stash.getAmount());
    }

}