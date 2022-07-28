import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int rows = size;
        int cols = size;
        int[][] matrix = new int[rows][cols];

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];
                if (row == col) {
                    firstDiagonalSum += matrix[row][col];
                }
            }
        }
        for (int row = 0, col = size - 1; row < size; row++, col--) {
            secondDiagonalSum += matrix[row][col];
        }

        int result = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(result);

    }
}
