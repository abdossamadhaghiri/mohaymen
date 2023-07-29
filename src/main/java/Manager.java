import java.util.ArrayList;

public class Manager {

    public ArrayList<String> answer;

    public Manager() {
        answer = new ArrayList<>();
    }

    public ArrayList<String> search(String key) {
        return Database.getDatabase().getInvertedIndex().get(key);

    }
}
