import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> text = new LinkedHashSet<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            text.add(input);
        }
        for (String line : text) {
            System.out.println(line);
        }



    }
}
