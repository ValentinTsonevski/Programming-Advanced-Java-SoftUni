import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int subMatrixSum = Integer.MIN_VALUE;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, matrix);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(subMatrixBoard(rows, cols, row, col)){
                int currentSumMatrixSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSumMatrixSum > subMatrixSum) {
                    subMatrixSum = currentSumMatrixSum;
                    num1 = matrix[row][col];
                    num2 = matrix[row][col + 1];
                    num3 = matrix[row + 1][col];
                    num4 = matrix[row + 1][col + 1];
                }
            }
            }
        }
        System.out.println(num1 + " " + num2);
        System.out.println(num3 + " " + num4);
        System.out.println(subMatrixSum);




    }

    private static boolean subMatrixBoard(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows -1 && col >=0 && col < cols - 1;
    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }
    }
}
