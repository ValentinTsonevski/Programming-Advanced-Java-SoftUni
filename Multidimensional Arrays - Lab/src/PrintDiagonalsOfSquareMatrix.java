import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int rows = sizeOfMatrix;
        int cols = sizeOfMatrix;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
                System.out.println();
        for (int col = 0; col < cols; col++) {
            for (int row = rows -1; row >= 0; row--) {
                System.out.print(matrix[row][col]+ " ");
                col ++;
            }
        }

    }
}
