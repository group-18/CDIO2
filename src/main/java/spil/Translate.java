package spil;

import java.io.*;
import java.util.HashMap;

public class Translate {
    private static Translate instance;

    private static String lang = "da_DK";


    private HashMap<String, String> translations;


    private Translate()
    {
        this.translations = new HashMap<String, String>();

        this.parseFile(this.getClass().getResource("/languages/" + Translate.getLang() + ".txt").getPath());
    }


    public static Translate getInstance()
    {
        if (! Translate.hasInstance()) {
            Translate.instance = new Translate();
        }

        return Translate.instance;
    }


    private static boolean hasInstance()
    {
        return Translate.instance != null;
    }


    public static String getLang()
    {
        return Translate.lang;
    }


    public static void setLang(String lang)
    {
        if (! Translate.hasInstance()) {
            Translate.lang = lang;
        }
    }


    public static String t(String key)
    {
        return Translate.getInstance().get(key);
    }


    public static String t(String key, String[] variables)
    {
        return Translate.getInstance().get(key, variables);
    }


    public String get(String key)
    {
        if (! this.translations.containsKey(key)) {
            return key;
        }

        String translation = this.translations.get(key);

        if (translation.equals("")) {
            return key;
        }

        return translation;
    }


    public String get(String key, String[] variables)
    {
        String translation = this.get(key);

        if (! translation.equals(key)) {
            for (int i = 0; i < variables.length; i++) {
                translation = translation.replaceAll("\\{\\{ ?#" + i + " ?\\}\\}", variables[i]);
            }
        }

        return translation;
    }


    private void parseFile(String filePath)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.equals("")) {
                    continue;
                }

                String[] keyValue = currentLine.split(":", 2);

                String key = keyValue[0];
                String val = keyValue.length == 1 ? "" : this.parseValue(keyValue[1]);

                if (! this.translations.containsKey(key)) {
                    this.translations.put(key, val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseValue(String val)
    {
        return val
                .replace(" \\n ", "\n")
                .replace("\\n", "\n");
    }
}
