import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];

            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = tokens[0];
            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                int oldRow = Integer.parseInt(tokens[1]);
                int oldCol = Integer.parseInt(tokens[2]);
                int newRow = Integer.parseInt(tokens[3]);
                int newCol = Integer.parseInt(tokens[4]);

                if ((oldRow > rows || oldCol > cols) || (newRow > rows || newCol > cols)) {
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String oldElement = matrix[oldRow][oldCol];
                    String newElement = matrix[newRow][newCol];

                    matrix[newRow][newCol] = oldElement;
                    matrix[oldRow][oldCol] = newElement;


                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }


                }


            }


            input = scanner.nextLine();
        }
    }
}