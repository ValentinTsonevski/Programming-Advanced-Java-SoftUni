import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] countCommands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int numberToOffer = countCommands[0];
        int numberToPoll = countCommands[1];
        int numberToFind = countCommands[2];

        for (int i = 0; i < numberToOffer; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < numberToPoll; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(numberToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }


    }
}
