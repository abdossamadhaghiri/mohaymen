package controller;

import model.Database;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    public List<String> answer;

    public Manager() {
        answer = new ArrayList<>();
    }

    public List<String> search(String key) {
        return Database.getDatabase().getRelatedDocuments(key);
    }
}
