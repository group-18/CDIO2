package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() throws Exception {
        Translate translate1 = Translate.getInstance();
        Translate translate2 = Translate.getInstance();
        assertEquals(translate1, translate2);
    }

    @Test
    public void getLang() throws Exception {
        String lang1 = Translate.getLang();
        assertTrue(lang1.equals("da_DK"));

        String
    }

    @Test
    public void setLang() throws Exception {
    }

    @Test
    public void t() throws Exception {
    }

    @Test
    public void t1() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void get1() throws Exception {
    }

}