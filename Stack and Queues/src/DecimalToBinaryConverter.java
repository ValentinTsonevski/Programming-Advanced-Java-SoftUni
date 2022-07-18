import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque numberToDecimal = new ArrayDeque();

        if(number == 0){
            System.out.println(0);
            return;
        }

        while (number > 0){
         numberToDecimal.push(number % 2);
          number /= 2;
        }
        while (!numberToDecimal.isEmpty()){
            System.out.print(numberToDecimal.pop());
        }





    }
}
