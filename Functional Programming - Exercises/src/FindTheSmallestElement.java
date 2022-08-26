import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>,Integer> minNumber = (List<Integer> list) ->{
            int min = Integer.MAX_VALUE;
            for (Integer intNum : list) {
                if(intNum < min){
                    min = intNum;
                }
            }
            return min;
        };
        int index = numbers.lastIndexOf(minNumber.apply(numbers));
        System.out.println(index);

    }
}
