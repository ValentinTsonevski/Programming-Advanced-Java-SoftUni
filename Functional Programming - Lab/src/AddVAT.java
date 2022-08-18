
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> elementPrice = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = element -> element * 1.20;
        System.out.println("Prices with VAT:");

        for (Double element : elementPrice) {
            Double priceWithVat = addVat.apply(element);
            System.out.printf("%.2f%n",priceWithVat);
        }

    }
}
