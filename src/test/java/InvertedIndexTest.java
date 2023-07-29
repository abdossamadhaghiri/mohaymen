import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class InvertedIndexTest {

    InvertedIndex invertedIndex = new InvertedIndex();

    @Test
    @Before
    public void testCreateInvertedIndex() {
        ArrayList<Document> documents = new ArrayList<>();
        documents.add(new Document("doc1", "this is a Test"));
        documents.add(new Document("doc2", "Hello world it is second doc"));
        documents.add(new Document("doc3", "third doc for a test  "));

        HashMap<String, ArrayList<String>> expected = new HashMap<>();
        ArrayList<String> doc1 = new ArrayList<>();
        doc1.add("doc1");
        ArrayList<String> doc2 = new ArrayList<>();
        doc2.add("doc2");
        ArrayList<String> doc3 = new ArrayList<>();
        doc3.add("doc3");
        ArrayList<String> doc12 = new ArrayList<>();
        doc12.add("doc1");
        doc12.add("doc2");
        ArrayList<String> doc13 = new ArrayList<>();
        doc13.add("doc1");
        doc13.add("doc3");
        ArrayList<String> doc23 = new ArrayList<>();
        doc23.add("doc2");
        doc23.add("doc3");

        expected.put("this", doc1);
        expected.put("is", doc12);
        expected.put("a", doc13);
        expected.put("test", doc13);
        expected.put("hello", doc2);
        expected.put("world", doc2);
        expected.put("it", doc2);
        expected.put("second", doc2);
        expected.put("doc", doc23);
        expected.put("third", doc3);
        expected.put("for", doc3);

        HashMap<String, ArrayList<String>> actual = invertedIndex.createInvertedIndex(documents);

        assertEquals(expected, actual);

    }

    @Test
    @Before
    public void testTokenize() {
        String text = "Agile is inspiring for data science. Being feedback driven by producing data is attractive.   ";
        List<String> actual = Arrays.asList("agile", "is", "inspiring", "for", "data", "science.", "being", "feedback",
                "driven", "by", "producing", "data", "is", "attractive.");

        List<String> expected = invertedIndex.tokenize(text);

        assertEquals(expected, actual);
    }


}
