package spil;

import java.io.*;
import java.util.HashMap;

public class Translate {
    private String lang;

    private HashMap<String, String> translations;


    public Translate(String lang) throws Exception
    {
        this.lang = lang;
        this.translations = new HashMap<>();

        try {
            this.parseFile(this.getClass().getResource("languages/" + this.lang + ".txt").getPath());
        } catch (FileNotFoundException e) {
            throw new Exception("Language " + this.lang + " is not supported");
        }
    }


    public String get(String key)
    {
        String translation = this.translations.getOrDefault(key, key);

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


    public String getLang()
    {
        return this.lang;
    }


    private void parseFile(String filePath) throws FileNotFoundException
    {
        BufferedReader b = new BufferedReader(new FileReader(filePath));

        try {
            String currentLine;
            while ((currentLine = b.readLine()) != null) {
                if (currentLine.equals("")) {
                    continue;
                }

                String[] keyValue = currentLine.split(":", 2);

                String key = keyValue[0];
                String val = keyValue.length == 1 ? "" : this.parseValue(keyValue[1]);

                this.translations.putIfAbsent(key, val);
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
