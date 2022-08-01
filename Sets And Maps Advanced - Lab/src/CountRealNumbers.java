import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double[] inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < inputNumbers.length; i++) {
            double currentNum = inputNumbers[i];
            numbers.putIfAbsent(currentNum,0);

            numbers.put(currentNum,numbers.get(currentNum) + 1);
        }

        for (Double key: numbers.keySet()){
            System.out.printf("%.1f -> %d%n",key,numbers.get(key));
        }

    }
}
