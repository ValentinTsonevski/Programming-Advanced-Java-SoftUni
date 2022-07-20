import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int number : numbers) {
            stackNumbers.push(number);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(stackNumbers.pop() + " ");
        }


    }
}
