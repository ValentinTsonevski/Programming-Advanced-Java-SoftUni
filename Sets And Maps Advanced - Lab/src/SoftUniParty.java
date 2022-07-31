import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> allGuests = new TreeSet<>();

        String command = scanner.nextLine();

        while (!command.equals("PARTY")) {
            allGuests.add(command);

            command = scanner.nextLine();
        }
        while (!command.equals("END")) {
            allGuests.remove(command);

            command = scanner.nextLine();
        }

        System.out.println(allGuests.size());
        allGuests.forEach(e -> {
            System.out.println(e);
        });


    }
}
