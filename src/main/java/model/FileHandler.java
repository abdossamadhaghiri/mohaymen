package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileHandler {

    public Map<String, String> readAllFiles(String path) {
        Map<String, String> nameAndTextOfDocuments = new HashMap<>();

        try {
            File directory = new File(path);

            for (File file : Objects.requireNonNull(directory.listFiles())) {
                String name = file.getName();
                String text = Files.readString(file.toPath());
                nameAndTextOfDocuments.put(name, text);
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return nameAndTextOfDocuments;
    }
}
