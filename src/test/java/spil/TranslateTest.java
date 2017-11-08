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

        Translate.setLang("en_EN");
        String lang2 = Translate.getLang();
        assertTrue(lang2.equals("en_EN"));
    }

    @Test
    public void setLang() throws Exception {
        Translate.setLang("en_EN");
        String lang3 = Translate.getLang();
        assertTrue(lang3.equals("en_EN"));
        Translate.setLang("da_DK");
        String lang4 = Translate.getLang();
        assertTrue(lang4.equals("da_DK"));
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