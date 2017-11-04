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
                .build();
        fields[1] = new Street.Builder()
                .setTitle("")
                .setSubText("")
                .setBgColor(Color.PINK).build();

        fields[2] = new Street.Builder()
                .setTitle("Tower")
                .setBgColor(Color.GREEN)
                .setSubText("+250")
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Crater")
                .setBgColor(Color.RED)
                .setSubText("-100")
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Palace gates")
                .setBgColor(Color.GREEN)
                .setSubText("+100")
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Cold Desert")
                .setBgColor(Color.RED)
                .setSubText("-20")
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Walled City")
                .setBgColor(Color.GREEN)
                .setSubText("+180")
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Monastery")
                .setBgColor(Color.LIGHT_GRAY)
                .setSubText("0")
                .build();
        fields[8] = new Street.Builder()
                .setTitle("Black Cave")
                .setBgColor(Color.RED)
                .setSubText("-70")
                .build();
        fields[9] = new Street.Builder()
            .setTitle("Huts in the mountain")
            .setBgColor(Color.GREEN)
            .setSubText("+60")
                .build();
        fields[10] = new Street.Builder()
                .setTitle("The Werewall")
                .setBgColor(Color.RED)
                .setSubText("-80 +EXTRA TUR")
                .build();
        fields[11] = new Street.Builder()
                .setTitle("The Pit")
                .setBgColor(Color.RED)
                .setSubText("-50")
                .build();
        fields[12] = new Street.Builder()
                .setTitle("Goldmine")
                .setBgColor(Color.YELLOW)
                .setSubText("+650")
                .build();

                GUI.create(fields);

    }

}
