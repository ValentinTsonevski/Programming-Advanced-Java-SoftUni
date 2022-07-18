import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String command = scanner.nextLine();
        String currentUrl = "blank";


        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!history.isEmpty()) {
                    currentUrl = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else {
                if (!currentUrl.equals("blank")) {
                    history.push(currentUrl);
                }
                currentUrl = command;
            }

            System.out.println(currentUrl);
            command = scanner.nextLine();
        }


    }
}
