import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[0]);
        String patternType = input[1];
        int counter = 1;

        int [][] matrix = new int[rows][cols];

      switch (patternType){
          case "A":
              patternA(rows, cols, counter, matrix);
              break;

          case "B":
              patternB(rows, cols, counter, matrix);
              break;
      }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void patternB(int rows, int cols, int counter, int[][] matrix) {
        for (int col = 0; col < cols; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }else{
                for (int row = rows -1 ; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void patternA(int rows, int cols, int counter, int[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
         matrix[row][col] = counter;
         counter++;
            }
        }
    }
}
