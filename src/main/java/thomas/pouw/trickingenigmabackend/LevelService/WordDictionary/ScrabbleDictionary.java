package thomas.pouw.trickingenigmabackend.LevelService.WordDictionary;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScrabbleDictionary {
    public static List<String> Dictionary = new ArrayList<>();

    public ScrabbleDictionary(){
        try{
            URL dictionary = new URL("https://web.stanford.edu/class/archive/cs/cs106l/cs106l.1102/assignments/dictionary.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(dictionary.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                Dictionary.add(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
