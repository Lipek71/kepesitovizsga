package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        Path outputPath = Path.of("src/main/java/hu/nive/ujratervezes/kepesitovizsga/" + output);
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Valamelyik paraméter hiányzik!");
        }

        try (BufferedWriter bf = Files.newBufferedWriter(outputPath)) {
            for (Map.Entry<String, String> items: contacts.entrySet()){
                bf.write(items.getKey() + ": " + items.getValue());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Nem tudom megnyitni a fájlt!", e);
        }
    }
}

