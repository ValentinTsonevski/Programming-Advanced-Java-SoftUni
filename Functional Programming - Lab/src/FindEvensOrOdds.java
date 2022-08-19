import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lower = range[0];
        int upper = range[1];

        String condition = scanner.nextLine();

        System.out.println(IntStream.rangeClosed(lower, upper).boxed()
                .filter(GetPredicate(condition))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    public static Predicate<Integer> GetPredicate(String condition) {
      switch (condition){
          case "odd":
              return n -> n % 2 != 0;

          case "even":
              return n -> n % 2 == 0;

          default:throw  new IllegalArgumentException("Unknown command " + condition);
      }

    }
}
