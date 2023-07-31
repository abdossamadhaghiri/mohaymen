package model;

import javax.swing.plaf.ListUI;
import java.util.*;

public class Database {

    private static Database database;
    private final List<Document> documents;
    private Map<String, List<String>> invertedIndex;

    private Database() {
        documents = new ArrayList<>();
        invertedIndex = new HashMap<>();
        updateDatabase();
    }

    public List<String> getRelatedDocuments(String key) {
        return this.invertedIndex.getOrDefault(key, new ArrayList<>());
    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private void updateDatabase() {

        //update documents
        Map<String, String> nameAndTextOfDocuments = new FileHandler().readAllFiles("src/main/resources/documents");
        for (String documentName : nameAndTextOfDocuments.keySet()) {
            this.documents.add(new Document(documentName, nameAndTextOfDocuments.get(documentName)));
        }
        //update inverted index
        this.invertedIndex = new InvertedIndex().createInvertedIndex(documents);

    }
}
