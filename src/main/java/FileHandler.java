import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHandler {

    public HashMap<String, String> readAllFiles(String path) {
        HashMap<String, String> nameAndTextOfDocuments = new HashMap<>();

        try {
            File directory = new File(path);

            for (File file : directory.listFiles()) {
                String name = file.getName();
                String text = Files.readString(file.toPath()).replaceAll("(\r\n)+", " ").replaceAll(" ( )+", " ").trim();
                nameAndTextOfDocuments.put(name, text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameAndTextOfDocuments;
    }
}
