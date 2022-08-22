import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                 .map(Integer::parseInt).collect(Collectors.toList());

        int toDivide = Integer.parseInt(scanner.nextLine());
       Collections.reverse(numbers);

        numbers.removeIf(n -> n % toDivide == 0);

        Consumer<Integer> printer = n -> System.out.print(n + " ");
        for (Integer number : numbers) {
            printer.accept(number);
        }

    }

}
