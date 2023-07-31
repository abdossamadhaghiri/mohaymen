package model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class InvertedIndex {

    private final Map<String, List<String>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new HashMap<>();
    }

    public Map<String, List<String>> createInvertedIndex(List<Document> documents) {

        for (Document document : documents) {
            Set<String> documentTokens = new HashSet<>(tokenize(document.text()));
            for (String token : documentTokens) {
                if (invertedIndex.containsKey(token)) {
                    invertedIndex.get(token).add(document.name());
                } else {
                    List<String> relatedDocument = new ArrayList<>();
                    relatedDocument.add(document.name());
                    invertedIndex.put(token, relatedDocument);
                }
            }
        }

        return invertedIndex;

    }

    public List<String> tokenize(String text) {
        return Arrays.asList(text.toLowerCase().trim().split("\\s+"));

    }
}
