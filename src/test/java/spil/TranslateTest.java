package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateTest {

    @Test
    public void getSetLang() throws Exception {
        String lang1 = Translate.getLang();
        assertTrue(lang1.equals("da_DK"));

        Translate.setLang("en_EN");
        assertTrue(Translate.getLang().equals("en_EN"));

        Translate.setLang("da_DK");
        assertTrue(Translate.getLang().equals("da_DK"));
    }

    @Test
    public void getInstance() throws Exception {
        assertEquals(Translate.getInstance(), Translate.getInstance());
    }

    @Test
    public void t() throws Exception {
        assertTrue(Translate.t("welcome1").equals("Velkommen til spillet."));
        assertTrue(Translate.t("writeName", new String[] {"2"}).equals("Nummer 2's navn"));
        assertTrue(Translate.t("empty").equals("empty"));
        assertTrue(Translate.t("notexist").equals("notexist")); // If string does not exist.

    }


}