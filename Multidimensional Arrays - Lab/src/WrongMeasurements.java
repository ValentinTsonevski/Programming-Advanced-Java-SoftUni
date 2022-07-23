import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        int cols = 0;
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
            cols = matrix[row].length;
        }
        int[] mistakenValueLocation = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wrongValue = matrix[mistakenValueLocation[0]][mistakenValueLocation[1]];

        List<Integer> newValues = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == wrongValue) {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;

                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
                        up = matrix[row - 1][col];
                    }
                    if (row + 1 < rows && matrix[row + 1][col] != wrongValue) {
                        down = matrix[row + 1][col];
                    }
                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
                        left = matrix[row][col - 1];
                    }
                    if (col + 1 < cols && matrix[row][col + 1] != wrongValue) {
                        right = matrix[row][col + 1];
                    }

                    int sum = up + down + left + right;

                    newValues.add(sum);
                }

            }
        }
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == wrongValue) {
                    matrix[row][col] = newValues.get(count);
                    count++;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
