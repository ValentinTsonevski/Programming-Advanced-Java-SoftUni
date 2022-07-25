import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String degrees = scanner.nextLine();
        List<String> wordList = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;
        String word = scanner.nextLine();

        while (!word.equals("END")) {
            int currentLength = word.length();

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            wordList.add(word);

            word = scanner.nextLine();
        }
        char[][] matrix = new char[wordList.size()][maxLength];
        int rows = wordList.size();
        int cols = maxLength;
        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    char currentChar = ' ';
                    matrix[row][col] = currentChar;
                }
            }
        }
        String angleInput = degrees.split("[()]")[1];
        int angle = Integer.parseInt(angleInput);

        switch (angle % 360) {

            case 0:

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {

                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;

            case 270:

                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

        }


    }
}
