
import java.util.ArrayList;
import java.util.Scanner;

public class UserHandler {

    public void run() {
        System.out.println("inter your key:");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        ArrayList<String> answer = new Manager().search(key);

        if (answer == null) {
            System.out.println("not found!");
        } else {
            for (String documentName : answer) {
                System.out.println(documentName);
            }
        }
    }

}
