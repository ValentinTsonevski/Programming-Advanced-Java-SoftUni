import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int number = matrix[row][col];
                if (number == numberToFind) {
                    System.out.print(row + " " + col + " ");
                    isFound = true;
                    System.out.println();
                }
            }

        }
        if (!isFound) {
            System.out.println("not found");
        }

    }
}
