
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private static Database database;
    private ArrayList<Document> documents;
    private HashMap<String, ArrayList<String>> invertedIndex;

    private Database() {
        documents = new ArrayList<>();
        invertedIndex = new HashMap<>();
        updateDatabase();
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public HashMap<String, ArrayList<String>> getInvertedIndex() {
        return invertedIndex;
    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private void updateDatabase() {

        //update documents
        this.documents = new FileHandler().readAllFiles();
        //update inverted index
        this.invertedIndex = new InvertedIndex().createInvertedIndex(documents);

    }
}
