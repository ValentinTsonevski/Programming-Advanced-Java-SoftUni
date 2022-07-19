import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommands; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            switch (command[0]) {
                case 1:
                    int elementToPut = command[1];
                    stack.push(elementToPut);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }
}
