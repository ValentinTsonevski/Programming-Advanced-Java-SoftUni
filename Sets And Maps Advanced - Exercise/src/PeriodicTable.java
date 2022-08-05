import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < numberOfElements; i++) {
            List<String> element = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            elements.addAll(element);
        }
        System.out.println(String.join(" ", elements));


    }
}
