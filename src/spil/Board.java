package spil;


import desktop_fields.Street;
import desktop_fields.Field;
import desktop_resources.*;

import java.awt.*;


public class Board {
    public static void boardgame()
    {

        Field[] fields = new Field[13];

        fields[0] = new Street.Builder()
                .setTitle("Start")
                .setSubText("")
                .setBgColor(Color.PINK)
                .setDescription("Start felt")
                .build();
        fields[1] = new Street.Builder()
                .setTitle("")
                .setSubText("")
                .setDescription("")
                .setBgColor(Color.PINK).build();

        fields[2] = new Street.Builder()
                .setTitle("Tower")
                .setBgColor(Color.GREEN)
                .setSubText("+250")
                .setDescription(Translate.t("field.tower.description"))
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Crater")
                .setBgColor(Color.RED)
                .setSubText("-100")
                .setDescription(Translate.t("field.crater.description"))
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Palace gates")
                .setBgColor(Color.GREEN)
                .setSubText("+100")
                .setDescription(Translate.t("field.palace_gates.description"))
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Cold Desert")
                .setBgColor(Color.RED)
                .setSubText("-20")
                .setDescription(Translate.t("field.cold_desert.description"))
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Walled City")
                .setBgColor(Color.GREEN)
                .setSubText("+180")
                .setDescription(Translate.t("field.walled_city.description"))
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Monastery")
                .setBgColor(Color.LIGHT_GRAY)
                .setSubText("0")
                .setDescription(Translate.t("field.monastery.description"))
                .build();
        fields[8] = new Street.Builder()
                .setTitle("Black Cave")
                .setBgColor(Color.RED)
                .setSubText("-70")
                .setDescription(Translate.t("field.black_cave.description"))
                .build();
        fields[9] = new Street.Builder()
                .setTitle("Huts in the mountain")
                .setBgColor(Color.GREEN)
                .setSubText("+60")
                .setDescription(Translate.t("field.huts_in_the_mountain.description"))
                .build();
        fields[10] = new Street.Builder()
                .setTitle("The Werewall")
                .setBgColor(Color.RED)
                .setSubText("-80 +EXTRA TUR")
                .setDescription(Translate.t("field.the_werewall.description"))
                .build();
        fields[11] = new Street.Builder()
                .setTitle("The Pit")
                .setBgColor(Color.RED)
                .setSubText("-50")
                .setDescription(Translate.t("field.the_pit.description"))
                .build();
        fields[12] = new Street.Builder()
                .setTitle("Goldmine")
                .setBgColor(Color.YELLOW)
                .setSubText("+650")
                .setDescription(Translate.t("field.goldmine.description"))
                .build();

                GUI.create(fields);

    }

}
