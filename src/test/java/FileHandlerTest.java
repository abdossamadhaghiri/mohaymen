import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

public class FileHandlerTest {

    @Test
    public void readAllFilesTest() {
        String path = "src/test/resources";

        HashMap<String, String> expected = new HashMap<>();

        String text1 = "the file is second one. salam. khoobi? che khabara? boro baba. ya ali!";
        String text2 = "hellow this is a test. it's first file. we are going to search a key in this file and file2. " +
                "goodbye everyone. abdossamad haghiri.";

        expected.put("doc1.txt", text1);
        expected.put("doc2.txt", text2);

        HashMap<String, String> actual = new FileHandler().readAllFiles(path);

        assertEquals(expected, actual);

    }


}
