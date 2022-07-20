import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stackedNumbers = new ArrayDeque<>();

        int elementsToPush = commands[0];
        int elementsToPop = commands[1];
        int numberToFind = commands[2];

        for (int i = 0; i < elementsToPush; i++) {
            stackedNumbers.push(numbers[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            stackedNumbers.pop();
        }
        if(stackedNumbers.isEmpty()) {
            System.out.println(0);
        }
       else if (stackedNumbers.contains(numberToFind)) {
            System.out.println("true");

        } else {
            System.out.println(Collections.min(stackedNumbers));
        }


    }
}
