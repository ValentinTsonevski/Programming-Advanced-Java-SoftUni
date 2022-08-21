import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        UnaryOperator<List<Integer>> calculateAdd = list -> list.stream().map(num -> num + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> calculateSubtract = list -> list.stream().map(num -> num - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> calculateMultiply = list -> list.stream().map(num -> num * 2).collect(Collectors.toList());
        Consumer<Integer> printer = num -> System.out.printf("%d ",num);

        String command = scanner.nextLine();
        while (!command.equals("end")){
           switch (command){
               case "add":
                numbers = calculateAdd.apply(numbers);
             break;

               case "multiply":
                 numbers = calculateMultiply.apply(numbers);
                   break;

               case "subtract":
                   numbers = calculateSubtract.apply(numbers);
                   break;

               case "print":
                   numbers.forEach(printer);
                   System.out.println();
                   break;
               default:
                   System.out.println("Unknown command");
           }

            command = scanner.nextLine();
        }


    }
}
