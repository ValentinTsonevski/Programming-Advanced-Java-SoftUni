import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int beeRow = 0;
        int beeCol = 0;
        int pollinatesFlower = 0;
        int flowersToPollinate = 5;


        for (int row = 0; row < size; row++) {

            List<Character> characterList = Arrays.stream(scanner.nextLine().split(""))
                    .map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
                matrix[row][col] = currentChar;
            }

        }

        int previousRow = beeRow;
        int previousCol = beeCol;
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    beeRow--;
                    if (isInMatrix(size, beeRow, beeCol)) {

                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow--;

                        }

                    } else {
                        System.out.println("The bee got lost!");

                        break;
                    }
                    break;

                case "down":
                    beeRow++;
                    if (isInMatrix(size, beeRow, beeCol)) {

                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow++;
                        }

                    } else {
                        System.out.println("The bee got lost!");

                        break;
                    }
                    break;

                case "left":
                    beeCol--;
                    if (isInMatrix(size, beeRow, beeCol)) {

                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol--;
                        }

                    } else {
                        System.out.println("The bee got lost!");

                        break;
                    }
                    break;

                case "right":
                    beeCol++;
                    if (isInMatrix(size, beeRow, beeCol)) {

                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol++;
                        }

                    } else {
                        System.out.println("The bee got lost!");

                        break;
                    }
                    break;

            }
            if (isInMatrix(size,beeRow,beeCol)){
                if (matrix[beeRow][beeCol] == 'f') {
                    pollinatesFlower++;

                    matrix[previousRow][previousCol] = '.';
                    matrix[beeRow][beeCol] = '.';

                }
        }

            command = scanner.nextLine();

        }

        if (pollinatesFlower < flowersToPollinate) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", flowersToPollinate - pollinatesFlower);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatesFlower);
        }
        matrix[beeRow][beeCol] = 'B';

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static boolean isInMatrix(int size, int beeRow, int beeCol) {
        return (beeRow >= 0 && beeRow < size) && (beeCol >= 0 && beeCol < size);
    }

}
