import model.Database;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class DatabaseTest {

    @Test
    public void databaseTest() {
        Database database = Database.getDatabase();
        String key = "abdossamad";
        List<String> actual = database.getRelatedDocuments(key);

        List<String> expected = new ArrayList<>();
        expected.add("doc2.txt");

        assertEquals(expected, actual);
    }
}
