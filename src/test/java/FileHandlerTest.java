import model.FileHandler;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FileHandlerTest {

    @Test
    public void readAllFilesTest() {
        String path = "src/test/resources";

        Map<String, String> expected = new HashMap<>();

        String text1 = "    the    file is       second one.\r\n" +
                "\r\n" +
                "salam. khoobi? che khabara?\r\n" +
                "   boro baba.\r\n" +
                "\r\n" +
                "ya ali!    ";
        String text2 = "hellow this is a test. it's first file.\r\n" +
                "we are going to search a key in this file and file2.\r\n" +
                "\r\n" +
                "goodbye everyone.\r\n" +
                "\r\n" +
                "abdossamad haghiri.";

        expected.put("doc1.txt", text1);
        expected.put("doc2.txt", text2);

        Map<String, String> actual = new FileHandler().readAllFiles(path);

        assertEquals(expected, actual);
    }


}
