package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StashTest {
    @Test
    public void getAmount() throws Exception {
        Stash stash = new Stash();
        assertEquals(0,stash.getAmount());
    }

    @Test
    public void addAmount() throws Exception {
        Stash stash = new Stash();
        //Vi starter med at være sikre på at amount = 0. Dette gør vi for at se om vores addAmount ændrer på noget.
        assertEquals(0,stash.getAmount());
        //Vi prøver så at bruge addAmount(400), for at se om den får tilføjet værdien.
        stash.addAmount(400);
        assertEquals(400,stash.getAmount());
        //Vi prøver at bruge addAmount til at få amount<0, og dermed sikre at den sætter amount=0 når amount<0.
        stash.addAmount(-1600);
        assertEquals(0,stash.getAmount());
    }

}