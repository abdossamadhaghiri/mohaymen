
import java.util.*;

public class InvertedIndex {

    private final HashMap<String, ArrayList<String>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> createInvertedIndex(ArrayList<Document> documents) {

        Set<String> allTokens = new HashSet<>();

        HashMap<Document, List<String>> tokens = new HashMap<>();

        //tokenize
        for (Document document : documents) {
            List<String> documentTokens = tokenize(document.getText());
            tokens.put(document, documentTokens);
            allTokens.addAll(documentTokens);
        }

        //make hashmap
        for (String token : allTokens) {
            ArrayList<String> relatedDocuments = new ArrayList<>();
            for (Document document : documents) {
                if (tokens.get(document).contains(token)) {
                    relatedDocuments.add(document.getName());
                }
            }
            invertedIndex.put(token, relatedDocuments);
        }

        return invertedIndex;

    }

    public List<String> tokenize(String text) {
        return Arrays.asList(text.toLowerCase().split(" "));
    }
}
