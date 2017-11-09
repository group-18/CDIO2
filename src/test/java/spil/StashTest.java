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
        //Vi starter med at være sikre på at amount = 1000. Dette gør vi for at se om vores addAmount ændrer på noget.
        assertEquals(1000,stash.getAmount());
        //Vi sætter vores forventede amount til 1400, og prøver så at bruge addAmount(400)
        stash.addAmount(400);
        assertEquals(1400,stash.getAmount());
        //Vi prøver at bruge addAmount til at få amount<0, og dermed sikre at den sætter amount=0 når amount<0.
        stash.addAmount(-1600);
        assertEquals(0,stash.getAmount());
    }

}