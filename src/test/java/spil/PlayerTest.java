package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() throws Exception {
        Player player = new Player("test");
        assertEquals("test",player.getName());

    }

    @Test
    public void getAmount() throws Exception {
        Player player = new Player("test");
        assertEquals(1000, player.getAmount());
    }

    @Test
    public void addAmount() throws Exception {
        Player player = new Player("test");
        //Vi starter med at være sikre på at amount = 1000. Dette gør vi for at se om vores addAmount ændrer på noget.
        assertEquals(1000,player.getAmount());
        //Vi sætter vores forventede amount til 1200, og prøver så at bruge addAmount(200).
        player.addAmount(200);
        assertEquals(1200,player.getAmount());
        //Vi prøver at bruge addAmount til at få amount<0, og dermed sikre at den sætter amount=0 når amount<0.
        player.addAmount(-1300);
        assertEquals(0,player.getAmount());
    }

}