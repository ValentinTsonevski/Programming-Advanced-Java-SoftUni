import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
       int cols = Integer.parseInt(scanner.nextLine());

       String[][] matrix1 = new String[rows][cols];
       String[][] matrix2 = new String[rows][cols];

        String[][] matrix3ToFill = new String[rows][cols];

        filMatrix1(scanner, rows, matrix1);
        fillMatrix2(scanner, rows, matrix2);

        fillMatrix3(rows, cols, matrix1, matrix2, matrix3ToFill);

        printMatrix3(rows, cols, matrix3ToFill);


    }

    private static void printMatrix3(int rows, int cols, String[][] matrix3ToFill) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix3ToFill[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix3(int rows, int cols, String[][] matrix1, String[][] matrix2, String[][] matrix3ToFill) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element1 = matrix1[row][col];
                String element2 = matrix2[row][col];
                if(!element1.equals(element2)){
                    matrix3ToFill[row][col] = "*";
                }else{
                    matrix3ToFill[row][col] = matrix1[row][col];
                }
            }
        }
    }

    private static void fillMatrix2(Scanner scanner, int rows, String[][] matrix2) {
        for (int row = 0; row < rows; row++) {
            String[] words2 = scanner.nextLine().split(" ");
            matrix2[row] = words2;
        }
    }

    private static void filMatrix1(Scanner scanner, int rows, String[][] matrix1) {
        for (int row = 0; row < rows; row++) {
            String[] words = scanner.nextLine().split(" ");
            matrix1[row] = words;
        }
    }
}
