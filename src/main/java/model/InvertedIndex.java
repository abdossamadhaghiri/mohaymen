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

        Set<String> allTokens = new HashSet<>();

        Map<Document, List<String>> tokens = new HashMap<>();

        //tokenize
        for (Document document : documents) {
            List<String> documentTokens = tokenize(document.text());
            tokens.put(document, documentTokens);
            allTokens.addAll(documentTokens);
        }

        //make hashmap
        for (String token : allTokens) {
            List<String> relatedDocuments = new ArrayList<>();
            for (Document document : documents) {
                if (tokens.get(document).contains(token)) {
                    relatedDocuments.add(document.name());
                }
            }
            invertedIndex.put(token, relatedDocuments);
        }

        return invertedIndex;

    }

    public List<String> tokenize(String text) {
        return Arrays.asList(text.toLowerCase().trim().split("\\s+"));
    }
}
