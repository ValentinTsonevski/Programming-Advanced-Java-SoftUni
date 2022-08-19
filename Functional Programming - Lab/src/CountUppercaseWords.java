import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> text = Arrays.stream(scanner.nextLine().split(" ")).filter(isUpperCase).collect(Collectors.toList());
        System.out.println(text.size());

        for (String word : text) {
            System.out.println(word);
        }

    }
}
