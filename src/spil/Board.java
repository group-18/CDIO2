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
                .setDescription("'Tower' er kendt for dens forrygende udsigt, desværre lider de fleste af højdeskræk, når de kommer op i 500m højde.")
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Crater")
                .setBgColor(Color.RED)
                .setSubText("-100")
                .setDescription("'Crater' lugter langt ude af gamle dinosaurer, månestøv og assorteret rumskibsskrald fra den seneste Apollo-mission.")
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Palace gates")
                .setBgColor(Color.GREEN)
                .setSubText("+100")
                .setDescription("Muren er stor, men dine picklocking-skills fra utallige timer i Skyrim har givet pote, og du underviser nogle skumle typer i at lirke døre op.")
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Cold Desert")
                .setBgColor(Color.RED)
                .setSubText("-20")
                .setDescription("Du husker tydeligt, at din mor bad dig om at tage en ekstra trøje med, og at du til dette svarede, at det da ikke bliver koldt i en ørken.")
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Walled City")
                .setBgColor(Color.GREEN)
                .setSubText("+180")
                .setDescription("Du ankommer til 'Walled city', som egentlig før du ankom bare hed 'city'. Dine evner inden for mursten og din viden i dit tidligere.")
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Monastery")
                .setBgColor(Color.LIGHT_GRAY)
                .setSubText("0")
                .setDescription("Du ankommer til 'Monastery', hvor det vrimler med alle verdens turister med hver deres bæltetaske, nyeste iPad til at tage billede og kæmpe solhatte.")
                .build();
        fields[8] = new Street.Builder()
                .setTitle("Black Cave")
                .setBgColor(Color.RED)
                .setSubText("-70")
                .setDescription("Du synes, at 'Black cave' lød spændende på TripAdvisor, nærmest adrenalinagtigt. Du bliver skuffet. 'No refunds' står der på billetten.")
                .build();
        fields[9] = new Street.Builder()
                .setTitle("Huts in the mountain")
                .setBgColor(Color.GREEN)
                .setSubText("+60")
                .setDescription("Det her sted er hyggeligt, nærmest eventyrligt anlagt med udsigt over de flotte bjerge, syngende fugle og sjove, frølignende skabninger, der råber: Mrlglglg.")
                .build();
        fields[10] = new Street.Builder()
                .setTitle("The Werewall")
                .setBgColor(Color.RED)
                .setSubText("-80 +EXTRA TUR")
                .setDescription("Du griner lidt over attraktionens navn, men du kan godt indse, at det er et desperat punkt på at være sjov, og derved bliver nødt til at skrive betydningen i parantes.")
                .build();
        fields[11] = new Street.Builder()
                .setTitle("The Pit")
                .setBgColor(Color.RED)
                .setSubText("-50")
                .setDescription("Du fortryder lidt, at du har brugt så lang tid på at gå ned i et hul, men du manglede en achievement.")
                .build();
        fields[12] = new Street.Builder()
                .setTitle("Goldmine")
                .setBgColor(Color.YELLOW)
                .setSubText("+650")
                .setDescription("## JACKPOT ## Du finder en kæmpe guldklump med værdi 650. Du når lige at råbe 'gg ez', inden du skifter tur.")
                .build();

                GUI.create(fields);

    }

}
