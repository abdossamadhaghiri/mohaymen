package view;

import controller.Manager;
import java.util.List;
import java.util.Scanner;

public class UserHandler {

    public void run() {
        System.out.println("enter your key:");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine().toLowerCase().trim();
        List<String> answer = new Manager().search(key);

        if (answer.size() == 0) {
            System.out.println("not found!");
        } else {
            for (String documentName : answer) {
                System.out.println(documentName);
            }
        }
    }

}
