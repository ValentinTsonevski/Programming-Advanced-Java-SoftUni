import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] screen = new char[screenSize][screenSize];

        int pythonRow = 0;
        int pythonCol = 0;
        int length = 1;
        int foodEaten = 0;
        int totalFood = 0;

        for (int row = 0; row < screenSize; row++) {

            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if(currentChar == 's'){
                pythonRow = row;
                pythonCol = col;
                }
                else if (currentChar == 'f'){
                    totalFood ++;
                }
                screen[row][col] = currentChar;
            }

        }

        for (int i = 0; i < commands.length; i++) {

            switch (commands[i]){
                case "up":
                    if(pythonRow != 0) {
                        pythonRow--;
                    }
                    else{
                       pythonRow = screen.length - 1;
                    }
                    break;

                case "down":
                if(pythonRow != screen.length - 1){
                   pythonRow ++;
                }
                else{
                pythonRow = 0;
                }
                    break;

                case "left":
                if(pythonCol != 0){
                    pythonCol --;
                }
                else{
                pythonCol = screen.length - 1;
                }
                    break;

                case "right":
                    if(pythonCol != screen.length -1){
                        pythonCol ++;
                    }
                    else{
                        pythonCol = 0;
                    }
                    break;

            }
            if(screen[pythonRow][pythonCol] == 'f'){
                foodEaten ++;
                length++;
                screen[pythonRow][pythonCol] = '*';

                if(foodEaten == totalFood){
                    System.out.printf("You win! Final python length is %s%n",length);
                    return;
                }
            }
            else if(screen[pythonRow][pythonCol] == 'e'){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

        }
        if(foodEaten <= totalFood) {
            System.out.printf("You lose! There is still %d food to be eaten.", totalFood - foodEaten);
        }


    }
}
