package spil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StashTest {
    Stash stash;


    @Before
    public void setUp() {
        this.stash = new Stash();
    }

    @Test
    public void getAmount() throws Exception {
        assertEquals(0, this.stash.getAmount());
    }

    @Test
    public void addAmount() throws Exception {
        //Vi starter med at være sikre på at amount = 0. Dette gør vi for at se om vores addAmount ændrer på noget.
        assertEquals(0, this.stash.getAmount());
        //Vi prøver så at bruge addAmount(400), for at se om den får tilføjet værdien.
        stash.addAmount(400);
        assertEquals(400, this.stash.getAmount());
        //Vi prøver at bruge addAmount til at få amount<0, og dermed sikre at den sætter amount=0 når amount<0.
        stash.addAmount(-1600);
        assertEquals(0, this.stash.getAmount());
    }

}