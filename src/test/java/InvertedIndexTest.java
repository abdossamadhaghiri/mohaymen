import model.Document;
import model.InvertedIndex;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvertedIndexTest {

    InvertedIndex invertedIndex = new InvertedIndex();

    @Test
    void testCreateInvertedIndex() {
        List<Document> documents = new ArrayList<>();
        documents.add(new Document("doc1", "this is a Test"));
        documents.add(new Document("doc2", "Hello world it is second doc"));
        documents.add(new Document("doc3", "a doc for a test"));

        Map<String, List<String>> expected = Map.of("this", List.of("doc1"), "is", List.of("doc1", "doc2"),
                "a", List.of("doc1", "doc3"), "test", List.of("doc1", "doc3"), "hello", List.of("doc2"),
                "world", List.of("doc2"), "it", List.of("doc2"), "second", List.of("doc2"),
                "doc", List.of("doc2", "doc3"), "for", List.of("doc3"));

        Map<String, List<String>> actual = invertedIndex.createInvertedIndex(documents);

        assertEquals(expected, actual);

    }

}
