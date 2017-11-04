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
        if (! this.translations.containsKey(key)) {
            return key;
        }

        String translation = this.translations.get(key);

        if (translation.equals("")) {
            return key;
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

                String[] keyValue = currentLine.split(":");

                String key = keyValue[0];
                String val = keyValue.length == 1 ? "" : keyValue[1];

                this.translations.putIfAbsent(key, val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
