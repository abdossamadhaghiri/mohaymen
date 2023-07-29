import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileHandler {

    public ArrayList<Document> readAllFiles() {
        ArrayList<Document> documents = new ArrayList<>();

        try {
            String path = "documents";
            File directory = new File(path);

            for (File file : directory.listFiles()) {
                String name = file.getName();
                String text = Files.readString(file.toPath()).replaceAll("(\r\n)+", " ");
                Document document = new Document(name, text);
                documents.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documents;
    }
}
