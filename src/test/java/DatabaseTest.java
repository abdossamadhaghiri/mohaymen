import model.Database;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseTest {

    @Test
    public void databaseTest() {
        Database database = Database.getDatabase();
        String key = "abdossamad";
        List<String> actual = database.getRelatedDocuments(key);

        List<String> expected = List.of("doc2.txt");

        assertEquals(expected, actual);
    }
}
