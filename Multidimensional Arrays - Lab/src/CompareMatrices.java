import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] firstMatrix = new int[rows][cols];
        firstMatrix(scanner, rows, cols, firstMatrix);

        int[] size2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows2 = size2[0];
        int cols2 = size2[1];
        int[][] secondMatrix = new int[rows2][cols2];
        SecondMatrix(scanner, rows2, cols2, secondMatrix);

        if((rows != rows2) || (cols != cols2)) {
            System.out.println("not equal");
        }else{
            boolean isEqual = true;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

             if(firstMatrix[row][col] != secondMatrix[row][col]){
                 isEqual = false;
                 break;
             }
                }
            }
            if(isEqual){
                System.out.println("equal");
            }else{
                System.out.println("not equal");
            }
        }


    }

    private static void SecondMatrix(Scanner scanner, int rows2, int cols2, int[][] secondMatrix) {
        for (int row = 0; row < rows2; row++) {
            int[] numbers2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                secondMatrix[row] = numbers2;

        }
    }

    private static void firstMatrix(Scanner scanner, int rows, int cols, int[][] firstMatrix) {
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                firstMatrix[row] = numbers;


        }
    }
}
