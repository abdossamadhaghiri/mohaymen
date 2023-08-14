import model.FileHandler;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileHandlerTest {

    @Test
    void readAllFilesTest() throws IOException {
        String path = "src/test/resources";

        Map<String, String> expected = new HashMap<>();

        File directory = new File(path);
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String name = file.getName();
            String text = Files.readString(file.toPath());
            expected.put(name, text);
        }

        Map<String, String> actual = new FileHandler().readAllFiles(path);

        assertEquals(expected, actual);
    }


}
