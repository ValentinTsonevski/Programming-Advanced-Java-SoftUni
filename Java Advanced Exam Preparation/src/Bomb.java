import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[size][size];

        int sapperRow = 0;
        int sapperCol = 0;

        boolean endOfRoute = false;

        int bombsOnField = 0;
        int foundBombs = 0;

        for (int row = 0; row < size; row++) {

            List<Character> characterList = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (currentChar == 'B') {
                    bombsOnField++;
                }
                field[row][col] = currentChar;
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch (command) {

                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;

                case "down":
                    if (sapperRow != field.length - 1) {
                        sapperRow++;
                    }
                    break;

                case "left":
                    if (sapperCol != 0) {
                        sapperCol--;
                    }
                    break;

                case "right":
                    if (sapperCol != field.length - 1) {
                        sapperCol++;
                    }
                    break;

            }

            if (field[sapperRow][sapperCol] == 'B') {
                foundBombs++;

                System.out.println("You found a bomb!");

                field[sapperRow][sapperCol] = '+';
            } else if (field[sapperRow][sapperCol] == 'e') {
                endOfRoute = true;
                break;
            }

        }
        field[sapperRow][sapperCol] ='s';

        if(bombsOnField == foundBombs){
            System.out.println("Congratulations! You found all bombs!");
        }
        else if (endOfRoute){
            System.out.printf("END! %d bombs left on the field",bombsOnField - foundBombs);
        }
        else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombsOnField - foundBombs,sapperRow,sapperCol);
        }

    }
}
