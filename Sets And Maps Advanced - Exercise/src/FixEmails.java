import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, String> peopleInfo = new LinkedHashMap<>();

        while (!line.equals("stop")) {
            String name = line;
            String email = scanner.nextLine();

            peopleInfo.put(name,email);

            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
            peopleInfo.remove(name,email);
            }

            line = scanner.nextLine();
        }

        for (var entry : peopleInfo.entrySet()){
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }
    }
}
