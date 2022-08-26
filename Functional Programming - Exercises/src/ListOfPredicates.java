import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int endRange = Integer.parseInt(scanner.nextLine());
      int startRange = 1;

        List<Integer> divideBy = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

           Predicate<Integer> isDivisible = number ->{
               for (Integer intToDivide : divideBy) {
                   if(number % intToDivide != 0){
                       return false;
                   }
               }
             return true;

           };
        for (int i = startRange; i <=endRange ; i++) {
            if(isDivisible.test(i)){
                System.out.print(i + " ");
            }
        }


    }
}
