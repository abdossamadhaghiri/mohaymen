
import java.util.*;

public class InvertedIndex {

    private final HashMap<String, ArrayList<String>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> createInvertedIndex(ArrayList<Document> documents) {

        Set<String> allTokens = new HashSet<>();

        //tokenize
        for (Document document : documents) {
            List<String> documentTokens = Arrays.asList(document.getText().toLowerCase().split(" "));
            allTokens.addAll(documentTokens);
        }

        //make hashmap
        for (String token : allTokens) {
            ArrayList<String> relatedDocuments = new ArrayList<>();
            for (Document document : documents) {
                if (document.getText().contains(token)) {
                    relatedDocuments.add(document.getName());
                }
            }
            invertedIndex.put(token, relatedDocuments);
        }

        return invertedIndex;


    }
}
