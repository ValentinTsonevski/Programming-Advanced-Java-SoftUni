import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> predicate = el -> el.length() <= length;
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).filter(predicate).collect(Collectors.toList());

        Consumer<String> printer = System.out::println;
        for (String name : names){
            printer.accept(name);
        }

    }
}
